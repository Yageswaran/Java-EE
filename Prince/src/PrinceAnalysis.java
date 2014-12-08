import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PrinceAnalysis {

	public static final long MAXRANDOM = 2147483647L;

	public static byte sbox[]    = { 0xB, 0xF, 0x3, 0x2,  0xA, 0xC, 0x9, 0x1,  0x6, 0x7, 0x8, 0x0,  0xE, 0x5, 0xD, 0x4 };
	public static byte sboxInv[] = { 0xB, 0x7, 0x3, 0x2,  0xF, 0xD, 0x8, 0x9,  0xA, 0x6, 0x4, 0x0,  0x5, 0xE, 0xC, 0x1 };

	public static short sbox_8[] = {
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

	public static short sboxInv_8[] = {
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

	public static void sbox4x4_8bit_Construct() {
		short i;
	    
		for (i=0; i<16; i++) {
			if (i != sboxInv[sbox[i]]) System.out.print("prob\n");
		}
	    
		for (i=0; i<256; i++) {
			if ((i%16)==0) System.out.print("\n");
			//pf("0x%02X, ", (sbox[(i & 0xF0) >> 4] << 4) | (sbox[i & 0x0F]));
			//pf("0x%02X, ", (sboxInv[(i & 0xF0) >> 4] << 4) | (sboxInv[i & 0x0F]));
		}
	    
		System.out.print("\n");
	}

	public static void fixedPointsSMSMh0() {
		int i;
		short x, y, count=0;
		short w[] = new short[16];
		short z[] = new short[16];
		byte j;
	    
		DecimalFormat nf4d = new DecimalFormat("0000"); 
		
		for (i=0; i<65536; i++) {
	        //for (i=0; i<3; i++) {
			/*
			 * APPLY S-BOX
			 */
			x = (short)(((sbox_8[(i & 0xFF00) >> 8] << 8) | (sbox_8[i & 0xFF])) & 0xFFFF);
			//pf("%04X -> %04X\n", i, x);
	        
			// take input bits w_{15}, w_{14},...,w_0
			for (j=15; j>=0; j--) {
				w[j] = (short) (((x & (1<<j)) >> j) & 0x1);
				//pf("%x", w[j]);
			}
	        
			/*
			 * APPLY 1/4 OF THE MATRIX M'
			 */
			// output bits after applying the matrix \hat{M}^{(0)}
			/*  F E D C B A 9 8 7 6 5 4 3 2 1 0
			 *
			 * [0 0 0 0|1 0 0 0|1 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 0 0 0|0 1 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 1 0|0 0 0 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 1|0 0 0 1|0 0 0 0]
			 * [-------+-------+-------+-------]
			 * [1 0 0 0|1 0 0 0|1 0 0 0|0 0 0 0]
			 * [0 0 0 0|0 1 0 0|0 1 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 0 0|0 0 1 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 1|0 0 0 0|0 0 0 1]
			 * [-------+-------+-------+-------]
			 * [1 0 0 0|1 0 0 0|0 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 1 0 0|0 1 0 0|0 0 0 0]
			 * [0 0 0 0|0 0 1 0|0 0 1 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 0|0 0 0 1|0 0 0 1]
			 * [-------+-------+-------+-------]
			 * [1 0 0 0|0 0 0 0|1 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 1 0 0|0 0 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 1 0|0 0 1 0|0 0 0 0]
			 * [0 0 0 0|0 0 0 1|0 0 0 1|0 0 0 1]
			 *
			 *  F E D C B A 9 8 7 6 5 4 3 2 1 0
			 *
			 */
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
	        
			y = 0;
			for (j=15; j>=0; j--) {
				y |= (z[j] << j);
			}
			//pf("y = %04X\n", y);
	        
			/*
			 * APPLY INVERSE S-BOX
			 */
			y = (short) (((sboxInv_8[(y & 0xFF00) >> 8] << 8) | (sboxInv_8[y & 0xFF])) & 0xFFFF);
	        
			if (y==i) {
				System.out.print(byteArray2String(short2Bytes(y)) + " ");
				count++;
				if (count % 16 == 0){
					System.out.println();
				}
			}
	        
		}
		System.out.println("\nHow many? " + count);
	}
	
	
	public static final String SPACE_SPLITER = " ";
	public static final String NO_SPLITER = "";
	static final String HEXES = "0123456789ABCDEF";
	
	public static String byteArray2String(byte[] raw, String spliter) {
		if (raw == null) {
			return null;
		}
		return byteArray2String(raw, 0, raw.length, spliter);
	}
	
	public static String byteArray2String(byte[] raw, int offset, int len, String spliter) {
		if (raw == null) {
			return null;
		}
		if (spliter == null) spliter = NO_SPLITER;
		final StringBuilder hex = new StringBuilder((2+spliter.length()) * len);
		boolean first = true;
		for (int i = offset; i < offset+len; i++) {
			if (!first)
				hex.append(spliter);
			hex.append(HEXES.charAt((raw[i] & 0xF0) >> 4)).append(
					HEXES.charAt((raw[i] & 0x0F)));
			first = false;
		}
		return hex.toString();
	}
	
	public static String byteArray2String(byte[] raw) {
		return byteArray2String(raw, NO_SPLITER);
	}
	
	public static byte[] short2Bytes(short value){
		return short2Bytes(value, ByteOrder.BIG_ENDIAN);
	}
	
	public static byte[] short2Bytes(short value, ByteOrder bo){
		ByteBuffer bb = ByteBuffer.allocate(2);
		bb.order(bo);
		bb.asShortBuffer().put(value);
		return bb.array();
	}
	
	public static byte[] int2Bytes(int value){
		return int2Bytes(value, ByteOrder.BIG_ENDIAN);
	}
	
	public static byte[] int2Bytes(int value, ByteOrder bo){
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.order(bo);
		bb.asIntBuffer().put(value);
		return bb.array();
	}
	
	public static byte[] long2Bytes(long value){
		return long2Bytes(value, ByteOrder.BIG_ENDIAN);
	}
	
	public static byte[] long2Bytes(long value, ByteOrder bo){
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.order(bo);
		bb.asLongBuffer().put(value);
		return bb.array();
	}

	public static void testIntegral() {
		long k0, k0p, k1;
		long m[] = new long[128];
		long c[] = new long[128];
		byte t;
		int i, j;
		long sum = 0, sum1, sum2, sum3;
		long sumA[] = new long[10]; // sum After S in the i-th R round
		long mm, cc;
		long RC[] = {
			0x0000000000000000L, 0x13198a2e03707344L, 0xa4093822299f31d0L, 0x082efa98ec4e6c89L,
			0x452821e638d01377L, 0xbe5466cf34e90c6cL, 0x7ef84f78fd955cb1L, 0x85840851f1ac43aaL,
			0xc882d32f25323c54L, 0x64a51195e0e3610dL, 0xd3b5a399ca0c2399L, 0xc0ac29b7c97c50ddL
		};
		long RCTemp[] = { 0,0,0,0, 0,0,0,0, 0,0,0,0 };
	    
		k0 = 0;
		k1 = 0xFEDCBA9876543210L;
		k0p = Prince.P(k0);
		t = 2;
	    
		/*
		 * Testing M
		 */
		/*
	     for (i=0; i<16; i++) {
	     //m[i] = 0x123456789ABCDEF ^ ((i & 0xF) << 60);
	     for (j=0; j<16; j++) {
	     m[i*16+j] = i | ((j & 0xF) << 60);
	     c[i*16+j] = Mp(m[i*16+j]);
	     //c[i*16+j] = SInv(MInv(SInv(Mp(S(Mp(m[i*16+j]))))));
	     sum ^= c[i*16+j];
	     pf("%016llX : %016llX\n", m[i*16+j], c[i*16+j]);
	     }
	     }
	     pf("Sum = %016llX\n", sum);
	     */
	    
		// set the 4 most significant nibbles to be active
		/*
	     for (i=0; i<65536; i++) {
	     mm = (i << 48);
	     //mm = ShiftRowInverse(mm);
	     
	     // 2 rounds (with the involution in the middle)
	     //cc = SInv(MInv(SInv(Mp(S(Mp(mm))))));
	     
	     // unbalanced after 4 rounds (with the involution in the middle)
	     cc = (MInv(SInv(MInv(SInv(Mp(S(M(S(Mp(S(mm)))))))))));
	     //cc = (MInv(SInv(MInv(SInv(Mp(S(M(S(M(S(mm)))))))))));
	     sum ^= cc;
	     }
	     pf("Sum = %016llX\n", sum);
	     */
	    
		/*
		 * Testing without involution in the middle
		 */
		/*
	     for (i=0; i<65536; i++) {
	     mm = (i << 48);
	     //c[i] = Mp(m[i]);
	     
	     // unbalanced after 4 rounds
	     cc = (M(S (M(S (M(S( M(S (Mp(mm))))))))));
	     sum ^= cc;
	     //pf("%016llX : %016llX\n", m[i], c[i]);
	     }
	     pf("Sum = %016llX\n", sum);
	     */
	    
		/*
		 * Testing involving the use of keys and tests whether if the plaintext set
		 * is balanced at the input, will the ciphertext set be balanced at the output?
		 */
		//*
		k0 = 0x0123456789ABCDEFL;
		k0p = Prince.P(k0);
		k1 = 0xFEDCBA9876543210L;
	    
		// number of R rounds (before + after the middle involution)
		t = 2; // even number only
		byte tMid = (byte) ((t/2) & 0xFF);
		long ALPHA = 0xc0ac29b7c97c50ddL;
		//u64 ALPHA = 0;
		System.out.println("Number of R rounds = " + t);
		System.out.println("tMid = " +  tMid);
	    
		//pf("tMid = %d\n", tMid);
		// modify RC if t<10
		if (t<10) {
			for (i=0; i<=tMid; i++)
				RCTemp[i] = RC[i];
			for (i=(tMid+1); i<=(t+1); i++)
				RCTemp[i] = RCTemp[t+1-i] ^ ALPHA;
			for (i=0; i<=(t+1); i++)
				RC[i] = RCTemp[i];
		}
	    
		Rngs.PlantSeeds(1);
		Rngs.SelectStream(2);
	    
		long constant;
		//u64 range = 65536;
	    
		long tweak = 0x40DEFF58DCF8DE0BL;
	    
//		constant = ((long)(Rngs.Random() * 65536) << 48) | ((long)(Rngs.Random() * 65536) << 32) |
//				   ((long)(Rngs.Random() * 65536) << 16) |  (long)(Rngs.Random() * 65536);
//		System.out.println("constant = " + byteArray2String(long2Bytes(constant)));
	    
		// just to validate using different set of constant
		sum = sum1 = sum2 = sum3 = 0;
		long pc;
		for (pc=0; pc<1; pc++) {
	        //for (pc=0; pc<32; pc++) {
	        //for (pc=0; pc<1024; pc++) {
	        //for (pc=0; pc<65536; pc++) {
	        
			sum = sum1 = sum2 = sum3 = 0;
			for (i=0; i<10; i++) {
				sumA[i] = 0;
			}
	        
			constant = ((long)(Rngs.Random() * 65536) << 48) | ((long)(Rngs.Random() * 65536) << 32) |
	        ((long)(Rngs.Random() * 65536) << 16) |  (long)(Rngs.Random() * 65536);
			constant ^= tweak;
	        
			for (i=0; i<16; i++) { // SET 1
	            //for (i=0; i<4096; i++) { // SET 2
	            //for (i=0; i<65536; i++) { // SET 3
	            //for (i=0; i<268435456; i++) { // SET 4
	            //for (i=0; i<4294967296; i++) { // SET 4b?
	            
				// prepare the plaintext set
	            
				// SET 1: 2^4
				//mm = constant ^ (i << 60);
	            
				// SET 1a: 2^4 but spread the active bits through 4 S-boxes and the active bit is the right-most
				//		   bit of nibbles 0, 4, 8, 12 (least significant bit)
				//mm = constant ^ (((i & 0x8) <<57) | ((i & 0x4) << 42) | ((i & 0x2) << 27) | ((i & 0x1) << 12));
	            
				// SET 1b: 2^4 but spread the active bits through 4 S-boxes and the active bit is the right-most
				//		   bit of nibbles 0, 1, 2, 3 (least significant bit)
				//mm = constant ^ (((i & 0x8) <<57) | ((i & 0x4) << 54) | ((i & 0x2) << 51) | ((i & 0x1) << 48));
	            
				// SET 1c: 2^4 but spread the active bits through 4 S-boxes and the active bit is the right-most
				//		   bit of nibbles 0, 5, 10, 15 (least significant bit)
				mm = constant ^ (((i & 0x8) <<57) | ((i & 0x4) << 38) | ((i & 0x2) << 19) | (i & 0x1));
	            
				// SET 2: 2^{12}
				//mm = constant ^ (i << 52);
	            
				// SET 3: BASIC 2^{16}
				//mm = constant ^ (i << 48);
	            
				// SET 4: (2^4)^7 = 2^{28}
				//mm = constant ^ (i << 36);
	            
				// SET 5: ADVANCED (add additional round but need to be able to 'detect' the
				//                  right set of nibbles going into the first S layer)
				/*
	             mm = (i << 48);
	             mm = ShiftRowInverse(mm);
	             mm = Mp(mm);
	             mm = SInv(mm);
	             */
	            
				System.out.print(byteArray2String(long2Bytes(mm)) + " - ");
	            
				cc = mm;
	            
				cc ^= k1;
				cc ^= RC[0];
	            
				// the first rounds/2 R rounds
				for (j=1; j<=tMid; j++) {
					cc = Prince.M(Prince.S(cc));
					cc ^= RC[j];
					cc ^= k1;
					sumA[j] ^= cc;
					System.out.print("(" + byteArray2String(long2Bytes(j)) +") " 
							+ byteArray2String(long2Bytes(cc)) +" - ");
				}
	            
				// the middle involution
				cc = Prince.S(cc);
				sum1 ^= cc;
				cc = Prince.SInv(Prince.Mp(cc));
	            
				sum2 ^= cc;
	            
				// the remaining rounds/2 R rounds
				for (j=(tMid+1); j<=t; j++) {
					cc ^= k1;
					cc ^= RC[j];
					cc = Prince.SInv(Prince.MInv(cc));
					sumA[j] ^= cc;
					System.out.print("(" + byteArray2String(long2Bytes(j)) +") " 
							+ byteArray2String(long2Bytes(cc)) +" - ");
				}
				sum3 ^= Prince.S(cc);
				sum ^= cc;
				System.out.println(byteArray2String(long2Bytes(cc)));
			}
			// test the sum here
			if (sum2 != 0) System.out.println("Prob");
			//if (sumA[(tMid+1)] != 0) pf("Prob\n");
		}
	    
		//pf("Sums (after %d rounds,  after 1st S of involution,  after involution,  before S of final round,  after final round) \n", tMid);
		//pf("      %016llX,  %016llX,  %016llX,  %016llX\n", sum1, sum2, sum3, sum);
	    
		System.out.println("Sums");
		for (i=1; i<=tMid; i++) {
			System.out.print("(" + byteArray2String(long2Bytes(i)) + ") " 
					+ byteArray2String(long2Bytes(sumA[i])) + " ");
		}
		System.out.print(" < " + byteArray2String(long2Bytes(sum1)) + "  " 
				+ byteArray2String(long2Bytes(sum2)) + " > ");
		for (i=(tMid+1); i<=t; i++) {
			System.out.print("(" + byteArray2String(long2Bytes(i)) + ") " 
				+ byteArray2String(long2Bytes(sumA[i])));
		}
	    
		System.out.print("\nOther sums\n");
		System.out.print("bef  1 and aft " + byteArray2String(long2Bytes(t)) + " : " 
				+ byteArray2String(long2Bytes(sumA[t])) + "\n");
		for (i=1; i<tMid; i++) {
			System.out.print("bef " + byteArray2String(long2Bytes(i+1)).substring(14) + " and aft " 
				+ byteArray2String(long2Bytes(t-i)).substring(14) + " : " 
				+ byteArray2String(long2Bytes(sumA[i]^sumA[t-i])) + "\n");
		}
		System.out.print("aft " + byteArray2String(long2Bytes(tMid)).substring(14) + " and bef " 
				+ byteArray2String(long2Bytes(tMid+1)).substring(14) + " : " 
				+ byteArray2String(long2Bytes(sumA[tMid]^sum2)) + "\n");
	    
		//*/
	    
		/*
	     for (i=0; i<16; i++) {
	     m[i] = MInv(i << 60);
	     //m[i] = i << 60;
	     c[i] = encrypt(m[i], k0, k0p, k1, t);
	     sum ^= c[i];
	     pf("%016llX : %016llX\n", m[i], c[i]);
	     }
	     pf("Sum = %016llX\n", sum);
	     */
	}



	public static void fixedPointsSMSMh1() {
		int i;
		short x, y, count=0;
		short w[] = new short[16];
		short z[] = new short[16];
		int j;
	    
		for (i=0; i<65536; i++) {
	        //for (i=0; i<3; i++) {
			/*
			 * APPLY S-BOX
			 */
			x = (short)(((sbox_8[(i & 0xFF00) >> 8] << 8) | (sbox_8[i & 0xFF])) & 0xFFFF);
			//pf("%04X -> %04X\n", i, x);
	        
			// take input bits w_{15}, w_{14},...,w_0
			for (j=15; j>=0; j--) {
				w[j] = (short)((((x & (1<<j)) >> j) & 0x1) & 0xFFFF);
				//pf("%x", w[j]);
			}
	        
			/*
			 * APPLY 1/4 OF THE MATRIX M'
			 */
			// output bits after applying the matrix \hat{M}^{(1)}
			/*  F E D C B A 9 8 7 6 5 4 3 2 1 0
			 *
			 * [1 0 0 0|1 0 0 0|1 0 0 0|0 0 0 0]
			 * [0 0 0 0|0 1 0 0|0 1 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 0 0|0 0 1 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 1|0 0 0 0|0 0 0 1]
			 * [-------+-------+-------+-------]
			 * [1 0 0 0|1 0 0 0|0 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 1 0 0|0 1 0 0|0 0 0 0]
			 * [0 0 0 0|0 0 1 0|0 0 1 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 0|0 0 0 1|0 0 0 1]
			 * [-------+-------+-------+-------]
			 * [1 0 0 0|0 0 0 0|1 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 1 0 0|0 0 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 1 0|0 0 1 0|0 0 0 0]
			 * [0 0 0 0|0 0 0 1|0 0 0 1|0 0 0 1]
			 * [-------+-------+-------+-------]
			 * [0 0 0 0|1 0 0 0|1 0 0 0|1 0 0 0]
			 * [0 1 0 0|0 0 0 0|0 1 0 0|0 1 0 0]
			 * [0 0 1 0|0 0 1 0|0 0 0 0|0 0 1 0]
			 * [0 0 0 1|0 0 0 1|0 0 0 1|0 0 0 0]
			 *
			 *  F E D C B A 9 8 7 6 5 4 3 2 1 0
			 *
			 */
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
	        
			y = 0;
			for (j=15; j>=0; j--) {
				y |= (z[j] << j);
			}
			//pf("y = %04X\n", y);
	        
			/*
			 * APPLY INVERSE S-BOX
			 */
			y = (short)(((sboxInv_8[(y & 0xFF00) >> 8] << 8) | (sboxInv_8[y & 0xFF])) & 0xFFFF);
	        
			if (y==i) {
				System.out.print(byteArray2String(short2Bytes(y)));
				count++;
			}
	        
		}
		System.out.println("\nHow many? " + count);
	}

	public static void DDT(byte sbox2[]) {
	    byte counter[][];
	    int i, j;
	    FileOutputStream fos;
	    OutputStreamWriter osw;
	    PrintWriter output;
	    
	    // build 2D array
	    counter = new byte[16][];
	    for (i = 0; i < 16; i++){
	    	counter[i] = new byte[16];
	    }
	    
	    try {
			fos = new FileOutputStream("prince-ddt.txt");
		
		    osw = new OutputStreamWriter(fos);
		    output = new PrintWriter(osw);
		    
		    output.print("Difference Distribution Table of PRINCE\n\n");
		   	for (i = 0; i < 16; i++) {
		        for (j = 0; j < 16; j++) {
		            counter[i][j] = 0;
		        }
		    }
		    
		   	for (i = 0; i < 16; i++) {
		        for (j = 0; j < 16; j++) {
		            counter[i][sbox2[j] ^ sbox2[j ^ i]]++;
		        }
		    }
		    
		    /*
		     * print the DDT
		     */
		   	output.print("    ");
		    for (i = 0; i < 16; i++) {
		    	output.print(byteArray2String(int2Bytes(i)).substring(5));
		    }
		    output.print("\n");
		    for (i = 0; i < (4 + 16*4); i++) {
		    	output.print("-");
		    }
		    output.print("\n");
		    for (i = 0; i < 16; i++) {
		    	output.print(byteArray2String(int2Bytes(i)).substring(5));
		        for (j = 0; j < 16; j++) {
		            if (counter[i][j] == 0)
		            	output.print("  . ");
		            else
		            	output.print(byteArray2String(int2Bytes(counter[i][j] & 0xFF)).substring(5) + " ");
		        }
		        output.print("\n");
		    }
		    output.close();
		    osw.close();
		    fos.close();
	    
	    } catch (FileNotFoundException e) {
			System.out.println("Cannot open ciphertext file:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception:" + e.getMessage());
		}
	}


	/*******************************************************************************/
	/*
	 Purpose:
	 TIMESTAMP prints the current YMDHMS date as a time stamp.
	 Example:
	 31 May 2001 09:45:54 AM
	 Licensing:
	 This code is distributed under the GNU LGPL license.
	 Modified:
	 24 September 2003
	 Author:
	 John Burkardt
	 Parameters:
	 None
	 */
	public static void timestamp () {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh:mm:ss a");
	    System.out.println(sdf.format(Calendar.getInstance().getTime()));
	}

}
