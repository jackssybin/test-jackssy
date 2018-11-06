package com.qding.test.jvm;



public class GCTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=3  -Xloggc:d:/gclogdir/1.txt -XX:+PrintGCTimeStamps
     */
    public static void testAllocation() {
        byte[][] allocation=new byte[10][];
        allocation[0] = new byte[1 * _1MB];
        allocation[1] = new byte[1 * _1MB];
        allocation[2] = new byte[1 * _1MB];
        allocation[3] = new byte[1 * _1MB];
        allocation[4] = new byte[1 * _1MB];
        allocation[5] = new byte[1 * _1MB];
        allocation[6] = new byte[1 * _1MB];
        allocation[7] = new byte[1 * _1MB];
        allocation[8] = new byte[1 * _1MB];
        allocation[8] = new byte[1 * _1MB];
        allocation[9] = new byte[1 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}

/*
 * Java HotSpot(TM) 64-Bit Server VM (25.0-b70) for windows-amd64 JRE (1.8.0-b132), built on Mar  4 2014 03:46:18 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 16568252k(8814280k free), swap 33134668k(24737308k free)
CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:NewSize=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=3 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
0.117: [GC (Allocation Failure) [PSYoungGen: 6085K->1672K(8192K)] 6085K->5776K(18432K), 0.0021273 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.119: [GC (Allocation Failure) [PSYoungGen: 6982K->1664K(8192K)] 11086K->9864K(18432K), 0.0021126 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.121: [Full GC (Ergonomics) [PSYoungGen: 1664K->0K(8192K)] [ParOldGen: 8200K->9739K(10240K)] 9864K->9739K(18432K), [Metaspace: 2508K->2508K(1056768K)], 0.0040641 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen      total 8192K, used 1085K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 17% used [0x00000000ff600000,0x00000000ff70f748,0x00000000ffc00000)
  from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
  to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
 ParOldGen       total 10240K, used 9739K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 95% used [0x00000000fec00000,0x00000000ff582dc8,0x00000000ff600000)
 Metaspace       used 2515K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 271K, capacity 386K, committed 512K, reserved 1048576K
*/
