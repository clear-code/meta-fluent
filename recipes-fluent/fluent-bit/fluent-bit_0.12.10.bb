SUMMARY = "Data Collector tool for Embedded Linux"
DESCRIPTION = "Fluent Bit is a data collector tool for Embedded Linux, \
it support different kind of inputs and built-in metrics.              \
"

HOMEPAGE = "http://fluentbit.io"
BUGTRACKER = "https://github.com/fluent/fluent-bit/issues"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
SECTION = "net"

SRC_URI = "https://github.com/fluent/fluent-bit/archive/v0.12.10.tar.gz;name=archive \
          "
SRC_URI[archive.md5sum] = "befc4db476cae715e42ef806c11bb0a0"
SRC_URI[archive.sha256sum] = "1f20e3580948f819206e01cb649614189ec5f565063077a48e4bf2f31982f6eb"

PR = "r1"
PV = "0.12.10"

S = "${WORKDIR}/fluent-bit-${PV}"
HOST_SYS_ARCH = "${HOST_ARCH}"
HOST_SYS_TRIPLE = "${HOST_SYS_ARCH}-unknown-linux"
EXTRA_OECMAKE = "-DGNU_HOST=${HOST_SYS_TRIPLE} -DFLB_XBEE=1 -DFLB_WITHOUT_EXAMPLES=On"

inherit cmake

PACKAGES += "${PN}-service"

FILES_${PN}-service = "${systemd_unitdir}/system/fluent-bit.service"
FILES_${PN} = "${bindir}/fluent-bit"
FILES_${PN} += "${sysconfdir}/fluent-bit/*.conf"
INSANE_SKIP_${PN}-dev = "ldflags staticdev libdir dev-elf"
