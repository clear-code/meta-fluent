SUMMARY = "Data Collector tool for Embedded Linux"
DESCRIPTION = "Fluent Bit is a data collector tool for Embedded Linux, \
it support different kind of inputs and built-in metrics.              \
"

HOMEPAGE = "http://fluentbit.io"
BUGTRACKER = "https://github.com/fluent/fluent-bit/issues"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
SECTION = "net"

SRC_URI = "https://github.com/fluent/fluent-bit/archive/v0.11.4.tar.gz;name=archive \
          "
SRC_URI[archive.md5sum] = "76e7e2636eab27f6e3b8ff71e2e38c9a"
SRC_URI[archive.sha256sum] = "d3d3b53f0877e3d9df39cdfbac7eb78519df11cb1e8adc6bd78eb535895dd57a"

PR = "r0"
PV = "0.11.4"

S = "${WORKDIR}/fluent-bit-${PV}"
HOST_SYS_ARCH = "${HOST_ARCH}"
HOST_SYS_TRIPLE = "${HOST_SYS_ARCH}-unknown-linux"
EXTRA_OECMAKE = "-DGNU_HOST=${HOST_SYS_TRIPLE} -DFLB_XBEE=1 -DFLB_WITHOUT_EXAMPLES=On"

inherit cmake

PACKAGES += "${PN}-service"

FILES_${PN}-service = "${systemd_unitdir}/system/fluent-bit.service"
