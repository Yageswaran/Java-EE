import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class PrinceMain {
	public static String Format16X(long value){
		return PrinceAnalysis.byteArray2String(
				PrinceAnalysis.long2Bytes(value));
	}
	
	/** Get CPU time in nanoseconds. */  
	public static long getCpuTime( ) {  
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );  
	    return bean.isCurrentThreadCpuTimeSupported( ) ?  
	        bean.getCurrentThreadCpuTime( ) : 0L;  
	}
	
	public static void main(String[] args){
		long k0, k0p, k1, m, c, t;
		long alpha = 0xc0ac29b7c97c50ddL;
		byte princesbox[]    = { 0xB, 0xF, 0x3, 0x2,  0xA, 0xC, 0x9, 0x1,  0x6, 0x7, 0x8, 0x0,  0xE, 0x5, 0xD, 0x4 };
	    
		long t1 = PrinceMain.getCpuTime();
		long w1 = System.currentTimeMillis();
		//PrinceAnalysis.timestamp();
	    
		//sbox4x4_8bit_Construct();
		//PrinceAnalysis.fixedPointsSMSMh0();
		//PrinceAnalysis.fixedPointsSMSMh1();
	    
		//System.out.println("Test M' " + Format16X(Prince.Mp(0xBBBB040404041919L)));
	    
		long x = 0xBBBB040413941919L;
		//System.out.println("fixed point? " + Format16X(Prince.SInv(Prince.Mp(Prince.S(x)))));
	    
		x = 0x0123456789ABCDEFL;
		//System.out.println("M = " + Format16X(Prince.M(x)));
	    
		x = 0x0123456789ABCDEFL;
		//System.out.println("MInv = " + Format16X(Prince.MInv(x)));
	    
		//System.out.println("MInv x M = " + Format16X(Prince.MInv(Prince.M(x))));
	    
		/*
		 * Testing encryption
		 */
		k0 = 0;
		k1 = 0xFEDCBA9876543210L;
		//m = 0x0123456789ABCDEFL;
		m = 43211;
	    
		k0p = Prince.P(k0);
		t = 2;
	    
		//System.out.println("k0p = " + Format16X(k0p));
		c = Prince.Encrypt(m, k0, k0p, k1, t);
		System.out.println("");
		System.out.println("Encrypt\n" + m + " : " + Format16X(c));
		System.out.println("");
		m = Prince.Encrypt(c, k0p, k0, k1^alpha, t);
		System.out.println("Decrypt\n" + Format16X(c) + " : " + m);
	    
		//System.out.println("\nTest Integral\n-----\n");
		//PrinceAnalysis.testIntegral();
	    
		//System.out.print("\nTest S M' S'\n-----\n");
		//System.out.println(Format16X(m) + " : " + Format16X(Prince.S_Mp_SInv(m)) 
		//			+ " : " + Format16X(Prince.S_Mp_SInv(Prince.S_Mp_SInv(m))));
	    
		//PrinceAnalysis.DDT(princesbox);
	    
		System.out.println("\nCPU Time : " + (double)(PrinceMain.getCpuTime() - t1)/1000 + " seconds");
		System.out.println("Wall Time: " + (double)(System.currentTimeMillis() - w1)/1000000 + " seconds");
		PrinceAnalysis.timestamp();
	}
}
