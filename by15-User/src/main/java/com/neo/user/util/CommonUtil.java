package com.neo.user.util;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author By15
 * @date 2021/9/14 16:02
 */
public class CommonUtil {
	static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=".toCharArray();
	public static Long getUUID(){
		//随机生成一位整数
		int random = (int) (Math.random()*9+1);
		String valueOf = String.valueOf(random);
		//生成uuid的hashCode值
		int hashCode = UUID.randomUUID().toString().hashCode();
		//可能为负数
		if(hashCode<0){
			hashCode = -hashCode;
		}
		return Long.valueOf(valueOf + String.format("%015d", hashCode));
	}

	public static String getUUIDBits(int bits) {
		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString());
		long msb = uuid.getMostSignificantBits();
		long lsb = uuid.getLeastSignificantBits();
		char[] out = new char[24];
		int tmp = 0, idx = 0;
		// 基础写法
        /*tmp = (int) ((msb >>> 40) & 0xffffff);
        out[idx + 3] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 2] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;
        tmp = (int) ((msb >>> 16) & 0xffffff);
        out[idx + 3] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 2] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;
        tmp = (int) (((msb & 0xffff) << 8) | (lsb >>> 56 & 0xff));
        out[idx + 3] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 2] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;
        tmp = (int) ((lsb >>> 32) & 0xffffff);
        out[idx + 3] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 2] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;
        tmp = (int) ((lsb >>> 8) & 0xffffff);
        out[idx + 3] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 2] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;
        tmp = (int) (lsb & 0xff);
        out[idx + 3] = alphabet[64];
        out[idx + 2] = alphabet[64];
        tmp <<= 4;
        out[idx + 1] = alphabet[tmp & 0x3f];
        tmp >>= 6;
        out[idx] = alphabet[tmp & 0x3f];
        idx += 4;*/

		// 循环写法
		int bit = 0, bt1 = 8, bt2 = 8;
		int mask = 0x00, offsetm = 0, offsetl = 0;

		for(; bit < 16; bit += 3, idx += 4) {
			offsetm = 64 - (bit + 3) * 8;
			offsetl = 0;
			tmp = 0;

			if(bt1 > 3) {
				mask = (1 << 8 * 3) - 1;
			} else if(bt1 >= 0) {
				mask = (1 << 8 * bt1) - 1;
				bt2 -= 3 - bt1;
			} else {
				mask = (1 << 8 * ((bt2 > 3) ? 3 : bt2)) - 1;
				bt2 -= 3;
			}
			if(bt1 > 0) {
				bt1 -= 3;
				tmp = (int) ((offsetm < 0) ? msb : (msb >>> offsetm) & mask);
				if(bt1 < 0) {
					tmp <<= Math.abs(offsetm);
					mask = (1 << 8 * Math.abs(bt1)) - 1;
				}
			}
			if(offsetm < 0) {
				offsetl = 64 + offsetm;
				tmp |= ((offsetl < 0) ? lsb : (lsb >>> offsetl)) & mask;
			}

			if(bit == 15) {
				out[idx + 3] = alphabet[64];
				out[idx + 2] = alphabet[64];
				tmp <<= 4;
			} else {
				out[idx + 3] = alphabet[tmp & 0x3f];
				tmp >>= 6;
				out[idx + 2] = alphabet[tmp & 0x3f];
				tmp >>= 6;
			}
			out[idx + 1] = alphabet[tmp & 0x3f];
			tmp >>= 6;
			out[idx] = alphabet[tmp & 0x3f];
		}

		return new String(out, 0, bits);
	}
}
