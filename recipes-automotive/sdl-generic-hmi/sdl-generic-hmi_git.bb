SUMMARY = "HTML based reference HMI for SmartDeviceLink"
DESCRIPTION = "SmartDeviceLink (SDL) is a standard set of protocols and \
messages that connect applications on a smartphone to a vehicle head \
unit."
HOMEPAGE = "https://www.smartdevicelink.com"
SECTION = "app"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a25b457a3545e4e09764603fb0121de"

SRC_URI = "git://github.com/smartdevicelink/generic_hmi.git;branch=release/0.6.0"

PV = "0.6.0+git${SRCPV}"
SRCREV = "f5a16f446b894544a64307c669a16696a0ff22e4"

S = "${WORKDIR}/git"

PACKAGES = " \
    ${PN} \
"

FILES_${PN}_append = " \
    ${datadir}/smartdevicelink/generic_hmi/ \
"

do_install() {
    install -d ${D}${datadir}/smartdevicelink/generic_hmi
    install -m 0644 ${S}/index.html ${D}${datadir}/smartdevicelink/generic_hmi/
    install -d ${D}${datadir}/smartdevicelink/generic_hmi/build
    install -m 0644 ${S}/build/* ${D}${datadir}/smartdevicelink/generic_hmi/build
    install -d ${D}${datadir}/smartdevicelink/generic_hmi/fonts
    install -m 0644 ${S}/fonts/* ${D}${datadir}/smartdevicelink/generic_hmi/fonts
}

