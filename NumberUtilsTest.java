/*
 * Copyright 2013 Stephen Asbury
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 */

import junit.framework.*;

public class NumberUtilsTest extends TestCase
{
    public void testConvertShort()
    {
        short[] numbers = {-10,10,0,124,-124,Short.MIN_VALUE,Short.MAX_VALUE};
        
        for(int i=0,max=numbers.length;i<max;i++)
        {
            assertEquals(numbers[i],NumberUtils.convertToShort(NumberUtils.convertToBinary(numbers[i])));
        }
    }
    
    public void testConvertInt()
    {
        int[] numbers = {-10,10,0,124,-124,Short.MIN_VALUE,Short.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE};
        
        for(int i=0,max=numbers.length;i<max;i++)
        {
            assertEquals(numbers[i],NumberUtils.convertToInt(NumberUtils.convertToBinary(numbers[i])));
        }
    }
    
    public void testConvertLong()
    {
        long[] numbers = {-10,10,0,124,-124,Short.MIN_VALUE,Short.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Long.MIN_VALUE,Long.MAX_VALUE};
        
        for(int i=0,max=numbers.length;i<max;i++)
        {
            assertEquals(numbers[i],NumberUtils.convertToLong(NumberUtils.convertToBinary(numbers[i])));
        }
    }
    
    public void testConvertFloat()
    {
        float[] numbers = {-10,10,0,124,-124,Short.MIN_VALUE,Short.MAX_VALUE,0.6f,-0.6f,Float.MIN_VALUE,Float.MAX_VALUE,Float.POSITIVE_INFINITY};
        
        for(int i=0,max=numbers.length;i<max;i++)
        {
            assertTrue(numbers[i]==NumberUtils.convertToFloat(NumberUtils.convertToBinary(numbers[i])));
        }
    }
    
    public void testConvertDouble()
    {
        double[] numbers = {-10,10,0,124,-124,Short.MIN_VALUE,Short.MAX_VALUE,0.666,-0.666,Double.MAX_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY};
        
        for(int i=0,max=numbers.length;i<max;i++)
        {
			assertTrue(numbers[i]==NumberUtils.convertToDouble(NumberUtils.convertToBinary(numbers[i])));
        }
    }
    
    public void testSum()
    {
        int total=0;
        
        for(int i=0;i<101;i++)
        {
            total+=i;
            assertEquals(total,NumberUtils.calculateSum(i));
        }
    }
    
    public void testMapToIntervalInt()
    {
        assertEquals(0,NumberUtils.mapToInterval(0,0,100,10));
        assertEquals(0,NumberUtils.mapToInterval(1,0,100,10));
        assertEquals(10,NumberUtils.mapToInterval(14,0,100,10));
        assertEquals(80,NumberUtils.mapToInterval(79,0,100,10));
        assertEquals(100,NumberUtils.mapToInterval(99,0,100,10));
    }
    
    public void testEncodeDecodeInt()
    {
        int encoded,actual,mapped;
        byte[] bits;
        
        for(int i=0,max=101;i<max;i++)
        {
            actual = i;
            mapped = NumberUtils.mapToInterval(actual,0,100,50);
            bits = NumberUtils.encodeToInterval(actual,0,100,50);
            encoded = NumberUtils.decodeFromInterval(bits,0,100,50);
            
            assertEquals(mapped,encoded);
        }
    }
    
    public void testEncodeDecodeDouble()
    {
        double encoded,actual,mapped;
        byte[] bits;
        
        for(int i=0,max=10100;i<max;i++)
        {
            actual = i*0.01;
            mapped = NumberUtils.mapToInterval(actual,0.0,100.0,1000);
            bits = NumberUtils.encodeToInterval(actual,0.0,100.0,1000);
            encoded = NumberUtils.decodeFromInterval(bits,0.0,100.0,1000);
            assertTrue(mapped==encoded);
        }
    }
}
