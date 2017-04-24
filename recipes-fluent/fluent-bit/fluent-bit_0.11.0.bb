SUMMARY = "Data Collector tool for Embedded Linux"
DESCRIPTION = "Fluent Bit is a data collector tool for Embedded Linux, \
it support different kind of inputs and built-in metrics.              \
"

HOMEPAGE = "http://fluentbit.io"
BUGTRACKER = "https://github.com/fluent/fluent-bit/issues"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
SECTION = "net"

SRC_URI = "https://github.com/fluent/fluent-bit/archive/v0.11.0.tar.gz;name=archive \
           file://pr-243.patch \
          "
SRC_URI[archive.md5sum] = "f704937bfc5c5af69e879cdb5f7661f5"
SRC_URI[archive.sha256sum] = "5b4ffdfa70c5db194e50909bc46cfa5eeb928c70bdd15fa140f694e2b37bdd19"

PR = "r0"
PV = "0.11.0"

S = "${WORKDIR}/fluent-bit-${PV}"
HOST_SYS_ARCH = "${HOST_ARCH}"
HOST_SYS_TRIPLE = "${HOST_SYS_ARCH}-unknown-linux"
EXTRA_OECMAKE = "-DGNU_HOST=${HOST_SYS_TRIPLE} -DFLB_XBEE=1 -DFLB_WITHOUT_EXAMPLES=On"

inherit cmake

PACKAGES += "${PN}-service"

FILES_${PN}-service = "${systemd_unitdir}/system/fluent-bit.service"
