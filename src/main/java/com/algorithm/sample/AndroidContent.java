package com.algorithm.sample;

public class AndroidContent {

    /**
     * android 启动相关
     */
    // 1号进程
    // system/core/init/main.cpp
    // 1.先调用first_stage_init.cpp -> 挂载文件系统 -> 加载部分内核模块
    // 2.selinux.cpp 加载selinux policy
    // 3.init.cpp  初始化property，并启动property service   解析并执行/system/etc/init/hw/init.rc


    // zygote 启动
    // /system/bin/app_process64 -Xzygote /system/bin --zygote --start-system-server --socket-name=zygote
    // /frameworks/base/cmds/app_process/app_main.cpp 解析args启动Zygote
    // /frameworks/base/core/jni/AndroidRuntime.cpp 最终调用 start()方法启动Zygote
    // libnativehelper/JniInvocation.c  加载libart.so并获取3个符号
    // AndroidRuntime.cpp startVm 初始化vm参数，最好调用art中的符号 JNI_CreateJavaVM (art/runtime/jni/java_vm_ext.cc)
    // art/runtime/jni/java_vm_ext.cc 创建ART Runtime
    // art/runtime/runtime.cc    Init() 初始化ART ，创建ClassLinker，load native bridge，load jvmti agent
    // art/runtime/runtime.cc    start()初始化class类，String，Field， 加载jit，创建SystemClassLoader，开启守护线程
    // AndroidRuntime.cpp onVmCreated()  解析app_process中传入的className
    // AndroidRuntime.cpp  解析ZygoteInit 并执行 main方法
    // framework/base/core/java/com/android/internal/os/ZygoteInit.java
    // ZygoteInit preload  load class
    // ZygoteInit preloadResources  load Resources   AssetManager 加载 /system/framework/framework-res.apk
    // ZygoteInit nativePreloadAppProcessHALs
    // ZygoteInit preloadSharedLibraries
    // ZygoteInit preloadTextResources 多语言相关，字体Cache
    // ZygoteInit WebViewFactory.prepareWebViewInZygote()
    // ZygoteInit forkSystemServer fork system_server
    // ZygoteInit 最终SystemServer进程会启动 com.android.server.SystemServer main()

    // system_server 进程
    // 主要是启动系统服务








    // mirror::Class ART中的class镜像，java_lang_Class是java class调用mirror::Class的媒介

    /**
     * service zygote /system/bin/app_process64 -Xzygote /system/bin --zygote --start-system-server --socket-name=zygote
     *     class main
     *     priority -20
     *     user root
     *     group root readproc reserved_disk
     *     socket zygote stream 660 root system
     *     socket usap_pool_primary stream 660 root system
     *     onrestart exec_background - system system -- /system/bin/vdc volume abort_fuse
     *     onrestart write /sys/power/state on
     *     onrestart restart audioserver
     *     onrestart restart cameraserver
     *     onrestart restart media
     *     onrestart restart media.tuner
     *     onrestart restart netd
     *     onrestart restart wificond
     *     task_profiles ProcessCapacityHigh MaxPerformance
     *     critical window=${zygote.critical_window.minute:-off} target=zygote-fatal
     *
     * service zygote_secondary /system/bin/app_process32 -Xzygote /system/bin --zygote --socket-name=zygote_secondary --enable-lazy-preload
     *     class main
     *     priority -20
     *     user root
     *     group root readproc reserved_disk
     *     socket zygote_secondary stream 660 root system
     *     socket usap_pool_secondary stream 660 root system
     *     onrestart restart zygote
     *     task_profiles ProcessCapacityHigh MaxPerformance
     */

    /**
     * /proc/filesystem
     *
     * 支持挂载的文件系统
     * nodev	sysfs
     * nodev	tmpfs
     * nodev	bdev
     * nodev	proc
     * nodev	cgroup
     * nodev	cgroup2
     * nodev	cpuset
     * nodev	binfmt_misc
     * nodev	configfs
     * nodev	debugfs
     * nodev	tracefs
     * nodev	securityfs
     * nodev	sockfs
     * nodev	bpf
     * nodev	pipefs
     * nodev	ramfs
     * nodev	devpts
     * 	ext3
     * 	ext2
     * 	ext4
     * 	vfat
     * 	msdos
     * 	exfat
     * 	fuseblk
     * nodev	fuse
     * nodev	fusectl
     * nodev	virtiofs
     * nodev	overlay
     * nodev	incremental-fs
     * 	f2fs
     * 	erofs
     * nodev	selinuxfs
     * nodev	binder
     * nodev	pstore
     * nodev	functionfs
     */


    /**
     * /proc/cmdline
     *
     * stack_depot_disable=on
     * kasan.stacktrace=off
     * kvm-arm.mode=protected
     * cgroup_disable=pressure
     * console=ttyMSM0,115200n8
     * kpti=0
     * kernel.panic_on_rcu_stall=1
     * service_locator.enable=1
     * msm_rtb.filter=0x237
     * rcupdate.rcu_expedited=1
     * rcu_nocbs=0-7
     * ftrace_dump_on_oops swiotlb=noforce
     * loop.max_part=7
     * fw_devlink.strict=1
     * allow_mismatched_32bit_el0 cpufreq.default_governor=performance
     * printk.console_no_auto_verbose=0
     * kasan=off
     * sysctl.kernel.sched_pelt_multiplier=4
     * can.stats_timer=0
     * pcie_ports=compat
     * irqaffinity=0-2
     * disable_dma32=on
     * no-steal-acc cgroup.memory=nokmem,nosocket
     * video=vfb:640x400,bpp=32,memsize=3072000
     * disable_dma32=on swinfo.fingerprint=babylon:13/V14.1.10.0.TMVCNXM:user mtdoops.fingerprint=babylon:13/V14.1.10.0.TMVCNXM:user bootconfig  bootinfo.pureason=0x40001 bootinfo.pdreason=0x2 debug_ext.initrd_size=21246 hwid.hwid_value=589824 hwid.project=6 hwid.build_adc=65507 hwid.project_adc=24778 msm_drm.dsi_display0=qcom,mdss_dsi_m18_38_0c_0a_prim_dsc_cmd: msm_drm.dsi_display1=qcom,mdss_dsi_m18_38_0c_0a_sec_dsc_cmd: msm_drm.oled_wp=0bd80c3a msm_drm.sec_oled_wp=0bd60c3a msm_drm.debugpolicy=0x20 rootwait ro init=/init log_buf_len=2M loglevel=6 qcom_geni_serial.con_enabled=0 block2mtd.block2mtd=/dev/block/sda19,2097152 mtdoops.mtddev=0 mtdoops.record_size=2097152 mtdoops.dump_oops=0 printk.always_kmsg_dump=1 silent_boot.mode=nonsilent
     */

}
