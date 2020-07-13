package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private Map<Integer, String> userInfo = new HashMap<>();

    @Value("${REDIS_KEY}")
    private String REDIS_KEY;

    public User userLogin(HttpServletRequest request, HttpServletResponse response, User u) {

        RedisSerializer redisSerializer=new RedisSerializer() {
            @Override
            public byte[] serialize(Object o) throws SerializationException {
                return new byte[0];
            }

            @Override
            public Object deserialize(byte[] bytes) throws SerializationException {
                return null;
            }
        };
        redisTemplate.setKeySerializer(redisSerializer);
        User us = userMapper.login(u.getUsername());
        if (us == null) {
            return null;
        }
        String pass = string2MD5(u.getPassword());
        if (!pass.equals(us.getPassword())) {
            return null;
        }
        String token = "user_" + UUID.randomUUID().toString();
        if (!ObjectUtils.isEmpty(userInfo.get(us.getId()))) {
            String oldToken = userInfo.get(us.getId());
            redisTemplate.delete(oldToken);
        }
        userInfo.put(us.getId(), token);
        redisTemplate.opsForValue().set(token,us);

        return us;
    }
    public User getUserByToken(HttpServletResponse response, HttpServletRequest request){
        User us=null;
        String token =null;
        User o=(User)redisTemplate.opsForValue().get(token);
        return o;
    }
    public String string2MD5(String inStr){
        MessageDigest md5=null;
        try{
            md5=MessageDigest.getInstance("MD5");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        char[] charArray=inStr.toCharArray();
        byte[] byteArray=new byte[charArray.length];
        for (int i=0;i<charArray.length;i++){
            byteArray[i]=(byte)charArray[i];
        }
        byte[] md5Bytes=md5.digest(byteArray);
        StringBuffer hexValue=new StringBuffer();
        for (int i=0;i<md5Bytes.length;i++){
            int val=((int)md5Bytes[i]&0xff);
            if(val<16){
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
