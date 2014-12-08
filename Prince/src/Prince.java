
public class Prince {
	//0xc0ac29b7c97c50dd
	public static final long ALPHA = 0xc0ac29b7c97c50ddL;

	public static final long RC[] = {
		0x0000000000000000L, 0x13198a2e03707344L, 0xa4093822299f31d0L, 0x082efa98ec4e6c89L,
		0x452821e638d01377L, 0xbe5466cf34e90c6cL, 0x7ef84f78fd955cb1L, 0x85840851f1ac43aaL,
		0xc882d32f25323c54L, 0x64a51195e0e3610dL, 0xd3b5a399ca0c2399L, 0xc0ac29b7c97c50ddL
	};

	public static final short sbox_8bits[] = {
		0xBB, 0xBF, 0xB3, 0xB2, 0xBA, 0xBC, 0xB9, 0xB1, 0xB6, 0xB7, 0xB8, 0xB0, 0xBE, 0xB5, 0xBD, 0xB4,
		0xFB, 0xFF, 0xF3, 0xF2, 0xFA, 0xFC, 0xF9, 0xF1, 0xF6, 0xF7, 0xF8, 0xF0, 0xFE, 0xF5, 0xFD, 0xF4,
		0x3B, 0x3F, 0x33, 0x32, 0x3A, 0x3C, 0x39, 0x31, 0x36, 0x37, 0x38, 0x30, 0x3E, 0x35, 0x3D, 0x34,
		0x2B, 0x2F, 0x23, 0x22, 0x2A, 0x2C, 0x29, 0x21, 0x26, 0x27, 0x28, 0x20, 0x2E, 0x25, 0x2D, 0x24,
		0xAB, 0xAF, 0xA3, 0xA2, 0xAA, 0xAC, 0xA9, 0xA1, 0xA6, 0xA7, 0xA8, 0xA0, 0xAE, 0xA5, 0xAD, 0xA4,
		0xCB, 0xCF, 0xC3, 0xC2, 0xCA, 0xCC, 0xC9, 0xC1, 0xC6, 0xC7, 0xC8, 0xC0, 0xCE, 0xC5, 0xCD, 0xC4,
		0x9B, 0x9F, 0x93, 0x92, 0x9A, 0x9C, 0x99, 0x91, 0x96, 0x97, 0x98, 0x90, 0x9E, 0x95, 0x9D, 0x94,
		0x1B, 0x1F, 0x13, 0x12, 0x1A, 0x1C, 0x19, 0x11, 0x16, 0x17, 0x18, 0x10, 0x1E, 0x15, 0x1D, 0x14,
		0x6B, 0x6F, 0x63, 0x62, 0x6A, 0x6C, 0x69, 0x61, 0x66, 0x67, 0x68, 0x60, 0x6E, 0x65, 0x6D, 0x64,
		0x7B, 0x7F, 0x73, 0x72, 0x7A, 0x7C, 0x79, 0x71, 0x76, 0x77, 0x78, 0x70, 0x7E, 0x75, 0x7D, 0x74,
		0x8B, 0x8F, 0x83, 0x82, 0x8A, 0x8C, 0x89, 0x81, 0x86, 0x87, 0x88, 0x80, 0x8E, 0x85, 0x8D, 0x84,
		0x0B, 0x0F, 0x03, 0x02, 0x0A, 0x0C, 0x09, 0x01, 0x06, 0x07, 0x08, 0x00, 0x0E, 0x05, 0x0D, 0x04,
		0xEB, 0xEF, 0xE3, 0xE2, 0xEA, 0xEC, 0xE9, 0xE1, 0xE6, 0xE7, 0xE8, 0xE0, 0xEE, 0xE5, 0xED, 0xE4,
		0x5B, 0x5F, 0x53, 0x52, 0x5A, 0x5C, 0x59, 0x51, 0x56, 0x57, 0x58, 0x50, 0x5E, 0x55, 0x5D, 0x54,
		0xDB, 0xDF, 0xD3, 0xD2, 0xDA, 0xDC, 0xD9, 0xD1, 0xD6, 0xD7, 0xD8, 0xD0, 0xDE, 0xD5, 0xDD, 0xD4,
		0x4B, 0x4F, 0x43, 0x42, 0x4A, 0x4C, 0x49, 0x41, 0x46, 0x47, 0x48, 0x40, 0x4E, 0x45, 0x4D, 0x44
	};

	public static short sboxInv_8bits[] = {
		0xBB, 0xB7, 0xB3, 0xB2, 0xBF, 0xBD, 0xB8, 0xB9, 0xBA, 0xB6, 0xB4, 0xB0, 0xB5, 0xBE, 0xBC, 0xB1,
		0x7B, 0x77, 0x73, 0x72, 0x7F, 0x7D, 0x78, 0x79, 0x7A, 0x76, 0x74, 0x70, 0x75, 0x7E, 0x7C, 0x71,
		0x3B, 0x37, 0x33, 0x32, 0x3F, 0x3D, 0x38, 0x39, 0x3A, 0x36, 0x34, 0x30, 0x35, 0x3E, 0x3C, 0x31,
		0x2B, 0x27, 0x23, 0x22, 0x2F, 0x2D, 0x28, 0x29, 0x2A, 0x26, 0x24, 0x20, 0x25, 0x2E, 0x2C, 0x21,
		0xFB, 0xF7, 0xF3, 0xF2, 0xFF, 0xFD, 0xF8, 0xF9, 0xFA, 0xF6, 0xF4, 0xF0, 0xF5, 0xFE, 0xFC, 0xF1,
		0xDB, 0xD7, 0xD3, 0xD2, 0xDF, 0xDD, 0xD8, 0xD9, 0xDA, 0xD6, 0xD4, 0xD0, 0xD5, 0xDE, 0xDC, 0xD1,
		0x8B, 0x87, 0x83, 0x82, 0x8F, 0x8D, 0x88, 0x89, 0x8A, 0x86, 0x84, 0x80, 0x85, 0x8E, 0x8C, 0x81,
		0x9B, 0x97, 0x93, 0x92, 0x9F, 0x9D, 0x98, 0x99, 0x9A, 0x96, 0x94, 0x90, 0x95, 0x9E, 0x9C, 0x91,
		0xAB, 0xA7, 0xA3, 0xA2, 0xAF, 0xAD, 0xA8, 0xA9, 0xAA, 0xA6, 0xA4, 0xA0, 0xA5, 0xAE, 0xAC, 0xA1,
		0x6B, 0x67, 0x63, 0x62, 0x6F, 0x6D, 0x68, 0x69, 0x6A, 0x66, 0x64, 0x60, 0x65, 0x6E, 0x6C, 0x61,
		0x4B, 0x47, 0x43, 0x42, 0x4F, 0x4D, 0x48, 0x49, 0x4A, 0x46, 0x44, 0x40, 0x45, 0x4E, 0x4C, 0x41,
		0x0B, 0x07, 0x03, 0x02, 0x0F, 0x0D, 0x08, 0x09, 0x0A, 0x06, 0x04, 0x00, 0x05, 0x0E, 0x0C, 0x01,
		0x5B, 0x57, 0x53, 0x52, 0x5F, 0x5D, 0x58, 0x59, 0x5A, 0x56, 0x54, 0x50, 0x55, 0x5E, 0x5C, 0x51,
		0xEB, 0xE7, 0xE3, 0xE2, 0xEF, 0xED, 0xE8, 0xE9, 0xEA, 0xE6, 0xE4, 0xE0, 0xE5, 0xEE, 0xEC, 0xE1,
		0xCB, 0xC7, 0xC3, 0xC2, 0xCF, 0xCD, 0xC8, 0xC9, 0xCA, 0xC6, 0xC4, 0xC0, 0xC5, 0xCE, 0xCC, 0xC1,
		0x1B, 0x17, 0x13, 0x12, 0x1F, 0x1D, 0x18, 0x19, 0x1A, 0x16, 0x14, 0x10, 0x15, 0x1E, 0x1C, 0x11
	};

	public static long P(long x) {
		return (((x >> 1) | (x & 0x8000000000000000L)) ^ (x >> 63));
	}

	public static long S(long x) {
		return (((long)sbox_8bits[(int) ((x & 0xFF00000000000000L) >>> 56 & 0xFF)] << 56) ^
				((long)sbox_8bits[(int) ((x & 0x00FF000000000000L) >>> 48 & 0xFF)] << 48) ^
				((long)sbox_8bits[(int) ((x & 0x0000FF0000000000L) >>> 40 & 0xFF)] << 40) ^
				((long)sbox_8bits[(int) ((x & 0x000000FF00000000L) >>> 32 & 0xFF)] << 32) ^
				((long)sbox_8bits[(int) ((x & 0x00000000FF000000L) >>> 24 & 0xFF)] << 24) ^
				((long)sbox_8bits[(int) ((x & 0x0000000000FF0000L) >>> 16 & 0xFF)] << 16) ^
				((long)sbox_8bits[(int) ((x & 0x000000000000FF00L) >>>  8 & 0xFF)] <<  8) ^
	            (long)sbox_8bits[ (int) (x & 0x00000000000000FFL)]);
	}

	public static long SInv(long x) {
		return (((long)sboxInv_8bits[(int) ((x & 0xFF00000000000000L) >> 56 & 0xFF)] << 56) ^
				((long)sboxInv_8bits[(int) ((x & 0x00FF000000000000L) >> 48 & 0xFF)] << 48) ^
				((long)sboxInv_8bits[(int) ((x & 0x0000FF0000000000L) >> 40 & 0xFF)] << 40) ^
				((long)sboxInv_8bits[(int) ((x & 0x000000FF00000000L) >> 32 & 0xFF)] << 32) ^
				((long)sboxInv_8bits[(int) ((x & 0x00000000FF000000L) >> 24 & 0xFF)] << 24) ^
				((long)sboxInv_8bits[(int) ((x & 0x0000000000FF0000L) >> 16 & 0xFF)] << 16) ^
				((long)sboxInv_8bits[(int) ((x & 0x000000000000FF00L) >>  8 & 0xFF)] <<  8) ^
	            (long)sboxInv_8bits[ (int) (x & 0x00000000000000FFL & 0xFF)]);
	}

	public static long Mp(long x) {
		long x1;
		byte j;
		short w[] = new short[16];
		short z[] = new short[16];;
		long xx = 0;
	    
		/*
		 * 1st Block
		 */
		// take 16 bits
		x1 = (x & 0xFFFF000000000000L) >>> 48;
	    
		// take each bit
		for (j=15; j>=0; j--) w[j] = (short) (((x1 & (1<<j)) >>> j) & 0x1);
	    
		// multiply with $\hat{M}^{(0)}$
		z[15] = (short) (w[0xB] ^ w[  7] ^ w[  3]);
		z[14] = (short) (w[0xE] ^ w[  6] ^ w[  2]);
		z[13] = (short) (w[0xD] ^ w[  9] ^ w[  1]);
		z[12] = (short) (w[0xC] ^ w[  8] ^ w[  4]);
	    
		z[11] = (short) (w[0xF] ^ w[0xB] ^ w[  7]);
		z[10] = (short) (w[0xA] ^ w[  6] ^ w[  2]);
		z[ 9] = (short) (w[0xD] ^ w[  5] ^ w[  1]);
		z[ 8] = (short) (w[0xC] ^ w[  8] ^ w[  0]);
	    
		z[ 7] = (short) (w[0xF] ^ w[0xB] ^ w[  3]);
		z[ 6] = (short) (w[0xE] ^ w[0xA] ^ w[  6]);
		z[ 5] = (short) (w[  9] ^ w[  5] ^ w[  1]);
		z[ 4] = (short) (w[0xC] ^ w[  4] ^ w[  0]);
	    
		z[ 3] = (short) (w[0xF] ^ w[  7] ^ w[  3]);
		z[ 2] = (short) (w[0xE] ^ w[0xA] ^ w[  2]);
		z[ 1] = (short) (w[0xD] ^ w[  9] ^ w[  5]);
		z[ 0] = (short) (w[  8] ^ w[  4] ^ w[  0]);
	    
		// put in xx
		x1 = 0;
		for (j=15; j>=0; j--) x1 |= (z[j] << j);
		xx |= (x1 << 48);
		//pf("1 - %016llX\n", xx);
	    
		/*
		 * 2nd Block
		 */
		x1 = (x & 0x0000FFFF00000000L) >>> 32;
		for (j=15; j>=0; j--) w[j] = (short) (((x1 & (1<<j)) >> j) & 0x1);
	    
		z[15] = (short) (w[0xF] ^ w[0xB] ^ w[  7]);
		z[14] = (short) (w[0xA] ^ w[  6] ^ w[  2]);
		z[13] = (short) (w[0xD] ^ w[  5] ^ w[  1]);
		z[12] = (short) (w[0xC] ^ w[  8] ^ w[  0]);
	    
		z[11] = (short) (w[0xF] ^ w[0xB] ^ w[  3]);
		z[10] = (short) (w[0xE] ^ w[0xA] ^ w[  6]);
		z[ 9] = (short) (w[  9] ^ w[  5] ^ w[  1]);
		z[ 8] = (short) (w[0xC] ^ w[  4] ^ w[  0]);
	    
		z[ 7] = (short) (w[0xF] ^ w[  7] ^ w[  3]);
		z[ 6] = (short) (w[0xE] ^ w[0xA] ^ w[  2]);
		z[ 5] = (short) (w[0xD] ^ w[  9] ^ w[  5]);
		z[ 4] = (short) (w[  8] ^ w[  4] ^ w[  0]);
	    
		z[ 3] = (short) (w[0xB] ^ w[  7] ^ w[  3]);
		z[ 2] = (short) (w[0xE] ^ w[  6] ^ w[  2]);
		z[ 1] = (short) (w[0xD] ^ w[  9] ^ w[  1]);
		z[ 0] = (short) (w[0xC] ^ w[  8] ^ w[  4]);
	    
		// put in xx
		x1 = 0;
		for (j=15; j>=0; j--) x1 |= (z[j] << j);
		xx |= (x1 << 32);
		//pf("2 - %016llX\n", xx);
	    
		/*
		 * 3rd Block
		 */
		x1 = (x & 0x00000000FFFF0000) >> 16;
		for (j=15; j>=0; j--) w[j] = (short) (((x1 & (1<<j)) >> j) & 0x1);
	    
		z[15] = (short) (w[0xF] ^ w[0xB] ^ w[  7]);
		z[14] = (short) (w[0xA] ^ w[  6] ^ w[  2]);
		z[13] = (short) (w[0xD] ^ w[  5] ^ w[  1]);
		z[12] = (short) (w[0xC] ^ w[  8] ^ w[  0]);
	    
		z[11] = (short) (w[0xF] ^ w[0xB] ^ w[  3]);
		z[10] = (short) (w[0xE] ^ w[0xA] ^ w[  6]);
		z[ 9] = (short) (w[  9] ^ w[  5] ^ w[  1]);
		z[ 8] = (short) (w[0xC] ^ w[  4] ^ w[  0]);
	    
		z[ 7] = (short) (w[0xF] ^ w[  7] ^ w[  3]);
		z[ 6] = (short) (w[0xE] ^ w[0xA] ^ w[  2]);
		z[ 5] = (short) (w[0xD] ^ w[  9] ^ w[  5]);
		z[ 4] = (short) (w[  8] ^ w[  4] ^ w[  0]);
	    
		z[ 3] = (short) (w[0xB] ^ w[  7] ^ w[  3]);
		z[ 2] = (short) (w[0xE] ^ w[  6] ^ w[  2]);
		z[ 1] = (short) (w[0xD] ^ w[  9] ^ w[  1]);
		z[ 0] = (short) (w[0xC] ^ w[  8] ^ w[  4]);
	    
		// put in xx
		x1 = 0;
		for (j=15; j>=0; j--) x1 |= (z[j] << j);
		xx |= (x1 << 16);
		//pf("3 - %016llX\n", xx);
	    
		/*
		 * 4th Block
		 */
		x1 = (x & 0x000000000000FFFF);
		for (j=15; j>=0; j--) w[j] = (short) (((x1 & (1<<j)) >> j) & 0x1);
		z[15] = (short) (w[0xB] ^ w[  7] ^ w[  3]);
		z[14] = (short) (w[0xE] ^ w[  6] ^ w[  2]);
		z[13] = (short) (w[0xD] ^ w[  9] ^ w[  1]);
		z[12] = (short) (w[0xC] ^ w[  8] ^ w[  4]);
	    
		z[11] = (short) (w[0xF] ^ w[0xB] ^ w[  7]);
		z[10] = (short) (w[0xA] ^ w[  6] ^ w[  2]);
		z[ 9] = (short) (w[0xD] ^ w[  5] ^ w[  1]);
		z[ 8] = (short) (w[0xC] ^ w[  8] ^ w[  0]);
	    
		z[ 7] = (short) (w[0xF] ^ w[0xB] ^ w[  3]);
		z[ 6] = (short) (w[0xE] ^ w[0xA] ^ w[  6]);
		z[ 5] = (short) (w[  9] ^ w[  5] ^ w[  1]);
		z[ 4] = (short) (w[0xC] ^ w[  4] ^ w[  0]);
	    
		z[ 3] = (short) (w[0xF] ^ w[  7] ^ w[  3]);
		z[ 2] = (short) (w[0xE] ^ w[0xA] ^ w[  2]);
		z[ 1] = (short) (w[0xD] ^ w[  9] ^ w[  5]);
		z[ 0] = (short) (w[  8] ^ w[  4] ^ w[  0]);
	    
		// put in xx
		x1 = 0;
		for (j=15; j>=0; j--) x1 |= (z[j] << j);
		xx |= (x1);
		//pf("4 - %016llX\n", xx);
	    
		return xx;
	}

	public static long M(long x) {
		long xx;
	    
		x = Mp(x);
	    
		// ShiftRow
		//            0123456789ABCDEF
		xx  =  (x & 0xF000000000000000L);
		xx |= ((x & 0x00000F0000000000L) << 16);
		xx |= ((x & 0x0000000000F00000L) << 32);
		xx |= ((x & 0x000000000000000FL) << 48);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x0000F00000000000L);
		xx |= ((x & 0x000000000F000000L) << 16);
		xx |= ((x & 0x00000000000000F0L) << 32);
		xx |= ((x & 0x000F000000000000L) >> 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x00000000F0000000L);
		xx |= ((x & 0x0000000000000F00L) << 16);
		xx |= ((x & 0x00F0000000000000L) >> 32);
		xx |= ((x & 0x0000000F00000000L) >> 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x000000000000F000L);
		xx |= ((x & 0x0F00000000000000L) >> 48);
		xx |= ((x & 0x000000F000000000L) >> 32);
		xx |= ((x & 0x00000000000F0000L) >> 16);
	    
		return xx;
	}

	public static long MInv(long x) {
		long xx;
	    
		// Inverse ShiftRow
		//            0123456789ABCDEF
		xx  =  (x & 0xF000000000000000L);
		xx |= ((x & 0x0000000000000F00L) << 48);
		xx |= ((x & 0x0000000000F00000L) << 32);
		xx |= ((x & 0x0000000F00000000L) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x0000F00000000000L);
		xx |= ((x & 0x0F00000000000000L) >> 16);
		xx |= ((x & 0x00000000000000F0L) << 32);
		xx |= ((x & 0x00000000000F0000L) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x00000000F0000000L);
		xx |= ((x & 0x00000F0000000000L) >> 16);
		xx |= ((x & 0x00F0000000000000L) >> 32);
		xx |= ((x & 0x000000000000000FL) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x000000000000F000L);
		xx |= ((x & 0x000000000F000000L) >> 16);
		xx |= ((x & 0x000000F000000000L) >> 32);
		xx |= ((x & 0x000F000000000000L) >> 48);
	    
		xx = Mp(xx);
	    
		return xx;
	}

	/*
	 * Just the ShiftRow function, which is actually the application of
	 * the function M without invoking the function Mp
	 */
	public static long ShiftRow(long x) {
		long xx;
	    
		// ShiftRow
		//            0123456789ABCDEF
		xx  =  (x & 0xF000000000000000L);
		xx |= ((x & 0x00000F0000000000L) << 16);
		xx |= ((x & 0x0000000000F00000L) << 32);
		xx |= ((x & 0x000000000000000FL) << 48);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x0000F00000000000L);
		xx |= ((x & 0x000000000F000000L) << 16);
		xx |= ((x & 0x00000000000000F0L) << 32);
		xx |= ((x & 0x000F000000000000L) >> 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x00000000F0000000L);
		xx |= ((x & 0x0000000000000F00L) << 16);
		xx |= ((x & 0x00F0000000000000L) >> 32);
		xx |= ((x & 0x0000000F00000000L) >> 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x000000000000F000L);
		xx |= ((x & 0x0F00000000000000L) >> 48);
		xx |= ((x & 0x000000F000000000L) >> 32);
		xx |= ((x & 0x00000000000F0000L) >> 16);
	    
		return xx;
	}

	/*
	 * Just the Inverse ShiftRow function, which is actually the application of
	 * the function MInv without invoking the function Mp
	 */
	public static long ShiftRowInverse(long x) {
		long xx;
	    
		// Inverse ShiftRow
		//            0123456789ABCDEF
		xx  =  (x & 0xF000000000000000L);
		xx |= ((x & 0x0000000000000F00L) << 48);
		xx |= ((x & 0x0000000000F00000L) << 32);
		xx |= ((x & 0x0000000F00000000L) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x0000F00000000000L);
		xx |= ((x & 0x0F00000000000000L) >> 16);
		xx |= ((x & 0x00000000000000F0L) << 32);
		xx |= ((x & 0x00000000000F0000L) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x00000000F0000000L);
		xx |= ((x & 0x00000F0000000000L) >> 16);
		xx |= ((x & 0x00F0000000000000L) >> 32);
		xx |= ((x & 0x000000000000000FL) << 16);
	    
		//            0123456789ABCDEF
		xx |=  (x & 0x000000000000F000L);
		xx |= ((x & 0x000000000F000000L) >> 16);
		xx |= ((x & 0x000000F000000000L) >> 32);
		xx |= ((x & 0x000F000000000000L) >> 48);
	    
		return xx;
	}

	public static long R(long x, long k, int i) {
		long xx;
	    
		xx = x;
	    
		xx = S(xx);
		xx = M(xx);
		xx ^= RC[i];
		xx ^= k;
	    
		return xx;
	}

	public static long RInv(long x, long k, int i) {
		long xx;
	    
		xx = x;
	    
		xx ^= k;
		xx ^= RC[i];
		xx = MInv(xx);
		xx = SInv(xx);
	    
		return xx;
	}

	/*
	 * The application of S, followed by Mp and SInv
	 */
	public static long S_Mp_SInv(long x) {
		return (SInv(Mp(S(x))));
	}

	/*
	 * t is the tweak to the number of the application of the function R. For the original PRINCE, t = 10
	 */
	public static long  Encrypt(long m, long k0, long k0p, long k1, long t) {
		long c;
		short i;
		long RCTemp[] = { 0,0,0,0, 0,0,0,0, 0,0,0,0 };
	    
		byte tMid = (byte) ((t/2) & 0xFF);
		//pf("tMid = %d\n", tMid);
		// modify RC if t<10
		if (t<10) {
			for (i=0; i<=tMid; i++)
				RCTemp[i] = RC[i];
			for (i=(short)((tMid+1) & 0xFFFF); i<=(t+1); i++)
				RCTemp[i] = RCTemp[(int)((t+1-i) & 0x7FFFFFFF)] ^ ALPHA;
			for (i=0; i<=(t+1); i++)
				RC[i] = RCTemp[i];
		}
	    
		c = m ^ k0;
	    
		/*
		 * begin PRINCE core
		 */
		c ^= k1;
		c ^= RC[0];
	    
		for (i=1; i<=tMid; i++) {
			c = R(c, k1, i);
		}
	    
		c = S(c);
		c = Mp(c);
		c = SInv(c);
	    
		for (i=(short) ((tMid+1) & 0xFFFF); i<=t; i++) {
			c = RInv(c, k1, i);
		}
	    
		c ^= RC[(int)((t+1) & 0x7FFFFFFF)];
		c ^= k1;
	    
		/*
		 * end PRINCE core
		 */
	    
		c = c ^ k0p;
	    
		return c;
	}

}
