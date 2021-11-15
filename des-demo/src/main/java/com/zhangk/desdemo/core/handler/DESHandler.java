package com.zhangk.desdemo.core.handler;

import com.zhangk.desdemo.core.alais.DESType;
import com.zhangk.desdemo.util.RsaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description 自定义加解密类型处理器
 * @date 2021年11月15日
 */
@Slf4j
@MappedTypes(DESType.class)
public class DESHandler extends BaseTypeHandler<String> {

    static final int COLUM_SIZE = 100;

    static RSAPublicKey publicKey;

    static RSAPrivateKey privateKey;

    static {
        try {
            KeyPair keyPair = RsaUtil.getKeyPair();
            publicKey = (RSAPublicKey) keyPair.getPublic();
            privateKey = (RSAPrivateKey) keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            log.error("RsaUtil create keyPair fail", e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            String encrypt = RsaUtil.encrypt(parameter, publicKey);
            ps.setString(i, encrypt);
        } catch (Exception e) {
            log.error("encrypt message failed", e);
            // 加密失败，使用原始数据
            ps.setString(i, parameter);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) {
        try {
            String parameter = rs.getString(columnName);
            if (isEncrypt(parameter)) {
                return RsaUtil.decrypt(parameter, privateKey);
            }
            // 不是密文直接返回
            return parameter;
        } catch (Exception e) {
            log.error("decrypt message failed", e);
        }
        return null;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) {
        try {
            String parameter = rs.getString(columnIndex);
            if (isEncrypt(parameter)) {
                return RsaUtil.decrypt(parameter, privateKey);
            }
            return parameter;
        } catch (Exception e) {
            log.error("decrypt message failed", e);
        }
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) {
        try {
            String parameter = cs.getString(columnIndex);
            if (isEncrypt(parameter)) {
                return RsaUtil.decrypt(parameter, privateKey);
            }
            return parameter;
        } catch (Exception e) {
            log.error("decrypt message failed", e);
        }
        return null;
    }

    /**
     * 判断是否为加密过的内容
     * 如果是加密过的内容则需要解密，否则直接返回明文
     * 此处仅用长度作为判断是否为密文，应该不准确，正式项目上可以用一些其他方式来校验是否密文
     */
    private boolean isEncrypt(String parameter) {
        return parameter.length() > COLUM_SIZE;
    }
}
