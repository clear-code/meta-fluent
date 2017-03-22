SUMMARY = "Data Collector tool for Embedded Linux"
DESCRIPTION = "Fluent Bit is a data collector tool for Embedded Linux, \
it support different kind of inputs and built-in metrics.              \
"

HOMEPAGE = "http://fluentbit.io"
BUGTRACKER = "https://github.com/fluent/fluent-bit/issues"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
SECTION = "net"

SRC_URI = "https://github.com/fluent/fluent-bit/archive/v0.10.1.tar.gz"
SRC_URI[md5sum] = "eb36177b68ba68b7fe23f78b33b1b97d"
SRC_URI[sha256sum] = "78349c453c0546025ef38f7912f20f63f6d152c33ff36e77892afa2253b9ce48"

PR = "r0"
PV = "0.10.1"

S = "${WORKDIR}/fluent-bit-${PV}"
EXTRA_OECMAKE = "-DFLB_XBEE=1 -DFLB_WITHOUT_EXAMPLES=On"

inherit cmake

FILES_${PN} += "${systemd_unitdir}/system/fluent-bit.service"