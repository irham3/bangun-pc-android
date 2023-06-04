package com.kaizen.bangunpc.data

//import com.kaizen.bangunpc.R
//
//// Only temporary data class for testing
//data class Product(
//    val id: Int,
//    val image: Int,
//    val title: String,
//    val price: String,
//    val detail: String,
//)
//
//val dummyProducts = listOf(
//    Product(1, R.drawable.rakitan_intel1,
//        "PC RAKITAN | CPU KOMPUTER CORE i3 BARU GARANSI 1 TAHUN - CASE LUXY, HDD 500GB",
//        "Rp 1.545.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC1A\uD835\uDC24\uD835\uDC22\uD835\uDC2D\uD835\uDC1A\uD835\uDC27 \uD835\uDC02\uD835\uDC28\uD835\uDC2B\uD835\uDC1E \uD835\uDC22\uD835\uDFD1 \uD835\uDC07\uD835\uDC1E\uD835\uDC26\uD835\uDC1A\uD835\uDC2D \uD835\uDC0C\uD835\uDC2E\uD835\uDC2B\uD835\uDC1A\uD835\uDC21 & \uD835\uDC01\uD835\uDC1E\uD835\uDC2B\uD835\uDC20\uD835\uDC1A\uD835\uDC2B\uD835\uDC1A\uD835\uDC27\uD835\uDC2C\uD835\uDC22 \uD835\uDFCF \uD835\uDC13\uD835\uDC1A\uD835\uDC21\uD835\uDC2E\uD835\uDC27\n" +
//                "Spesifikasi ini Cocok Buat Keperluan Kantor Sekolah, Rumahan dan Kantor,\n" +
//                "\n" +
//                "belum bisa di pakai gaming dan editing render,untuk gaming dan render harus pakai vga lagi.\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Motherboard Chipset Intel H61\n" +
//                "✔ Intel Core i3 2120 Socket 1156\n" +
//                "✔ Memory DDR3 8GB PC 1600Mhz\n" +
//                "✔ HDD Seagate 500GB Sata\n" +
//                "✔ SSD 128/256 GB Sata (Pilih Varian)\n" +
//                "✔ VGA Card Integrated Onboard\n" +
//                "✔ Sound Card + Lan Card On Board\n" +
//                "✔ Casing Standar\n" +
//                "✔ PSU Standard\n" +
//                "✔ Keyboard Epraizer + Mouse"),
//
//    Product(2, R.drawable.rakitan_intel2,
//        "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB",
//        "Rp 11.641.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC06\uD835\uDC00\uD835\uDC0C\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC08\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC0B \uD835\uDC225 \uD835\uDC06\uD835\uDC04\uD835\uDC0D \uD835\uDFCF2\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : ENLIGHT RAMPAGE (Tempered Glass, Include Fan 4 RGB)\n" +
//                "✔ Processor : Intel®️ Core™️ i5 12400f\n" +
//                "✔ Motherboard : H610M-D ASUS\n" +
//                "✔ Memory : PNY XLR8 RGB 16GBKIT 3200\n" +
//                "✔ VGA : ASUS RX 6600 DUAL 8GB GDDR6\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ PSU : INNOVATION 500W BRONZE\n" +
//                "✔ CPU Cooler : PARADOX HYPERSONIC (4 Chopper Pipe, ARGB)\n" +
//                "✔ WIFI CARD (USB)\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(3, R.drawable.rakitan_intel3,
//        "PC RAKITAN GAMING - INTEL i3 GEN 10 SERIES | SSD 256GB - ASUS RX6600",
//        "Rp 8.365.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC06\uD835\uDC00\uD835\uDC0C\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC08\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC0B\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : INFINITY VESTA V2 (Tempered Glass, Include 4 Fan RGB)\n" +
//                "✔ Processor : Intel®️ Core™️ i3 10100f\n" +
//                "✔ Motherboard : MSI H510M PRO-E\n" +
//                "✔ Memory : PNY XLR8 16GB 3200\n" +
//                "✔ VGA : PALIT RTX 3050 / ASUS DUAL RX 6600 / INNO3D RTX 2060 SUPER\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ PSU : INNOVATION 500W BRONZE\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//
//    Product(4, R.drawable.rakitan_intel4,
//        "PC Rakitan i3 10100f | GTX 1650 | Casing Infinity | Siap pakai",
//        "Rp 6.980.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC06\uD835\uDC00\uD835\uDC0C\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC08\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC0B \uD835\uDC22\uD835\uDFD1 \uD835\uDC06\uD835\uDC04\uD835\uDC0D \uD835\uDFCF\uD835\uDFCE\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : INF Flash V2 include 3 Fan Rainbow\n" +
//                "✔ Processor : Intel®️ Core™️ i3 10100f\n" +
//                "✔ Motherboard : H410M-D ASUS\n" +
//                "✔ Memory : PNY XLR8 16GBKit 3200\n" +
//                "✔ VGA : 1650 4GB GDDR5\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ PSU : INNOVATION 400W BRONZE\n" +
//                "✔ CPU Cooler : Cooler Intel Stock\n" +
//                "✔ WIFI CARD (USB)\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(5, R.drawable.rakitan_intel5,
//        "PC Rakitan Gaming intel Core i3/RAM 8GB/HDD 1TB/Nvidia GT730/WIFI",
//        "Rp 3.340.000",
//        "Pc Rakitan Gaming Core i3 Murah, Tidak Murahan & Garansi 1tahun\n" +
//                "Best Buy untuk Lite Gaming,Kantoran & Render Medium.\n" +
//                "\n" +
//                "Spec PC :\n" +
//                "Motherboard Chipset Intel H61\n" +
//                "Proc Intel Core i3 2120\n" +
//                "Memory DDR3 8GB PC-12800 (1 Channel)\n" +
//                "Hardisk Seagate 1TB SATA\n" +
//                "VGA Geforce GT730 2GB DDR3 128Bit\n" +
//                "Sound infinity VESTA V2 (inc 4x12cm Rainbow Fan LED)\n" +
//                "PSU infinity 420W\n" +
//                "WIFI RECEIVER Include\n"),
//
//    Product(6, R.drawable.rakitan_intel6,
//        "PC RAKITAN GAMING - INTEL i3 GEN 10 SERIES | RX550 4GB | SSD 256GB - DS Black + 16gb",
//        "Rp 6.035.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC06\uD835\uDC00\uD835\uDC0C\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC08\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC0B \uD835\uDC22\uD835\uDFD1 \uD835\uDC06\uD835\uDC04\uD835\uDC0D \uD835\uDFCF\uD835\uDFCE\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : DRAGON SLAYER WHITE/BLACK (Tempered Glass, Include Fan RGB)\n" +
//                "✔ Processor : Intel®️ Core™️ i3 10100F/10105F\n" +
//                "✔ Motherboard : ASUS H410M-D\n" +
//                "✔ Memory : PNY XLR8 RGB 8/16/32GB KIT 3200\n" +
//                "✔ VGA : AFOX RX550 4GB GDDR5\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ PSU : INNOVATION 400W BRONZE\n" +
//                "✔ CPU Cooler : Cooler Intel Stock\n" +
//                "✔ WIFI CARD (USB)\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(7, R.drawable.rakitan_intel7,
//        "PC RAKITAN GAMING i9 13900KF | RTX 4070 TI | MAX RENDER MAX GAMING - 32GB DDR5 6000",
//        "Rp 40.535.000",
//        "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : Paradox Tomorrow Series 5\n" +
//                "✔ Processor : Intel Core i9 13900KF\n" +
//                "✔ Motherboard : ASUS PRIME Z790-A CSM WIFI\n" +
//                "✔ Memory : PNY XLR8 MAKO RGB 2X16GB DDR5 6000Mhz/64GB (32GB x 2) TEAM ELITE DDR5 4800/ 16GB X 4 XLR8 MAKO RGB DDR5 6000\n" +
//                "✔ VGA : PNY RTX 4070 TI 12GB OC TRIPLE FAN ARGB\n" +
//                "✔ SSD : PNY NVME GEN 4 1TB\n" +
//                "✔ PSU : BITFENIX WHISPER 850W GOLD\n" +
//                "✔ CPU Cooler : NZXT Kraken X73 RGB 360mm AIO Liquid Cooler With Aer RGB Fans\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(8, R.drawable.rakitan_intel8,
//        "PC Rakitan Gaming intel Core i3 | RAM 8GB | HDD 500GB Nvidia GT730 2GB - SPICA",
//        "Rp 3.400.000",
//        "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing Gaming Paradox (Varian produk)\n" +
//                "✔ Processor : Intel®️ Core™️ i3 2120\n" +
//                "✔ Motherboard Chipset Intel H61\n" +
//                "✔ Memory DDR3 8GB/16GB (2*8) PC-12800 (varrian produk)\n" +
//                "✔ VGA Geforce GT 730 2GB\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ HDD Seagate 500GB Sata\n" +
//                "✔ PSU 400 Watt\n" +
//                "✔ CPU Cooler : PARADOX GAMING HYPERSONIC CL-2900\n" +
//                "✔ WIFI CARD (USB)\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(9, R.drawable.rakitan_intel9,
//            "PC RAKITAN KANTOR Intel Core I3 | 16GB DDR3 | SSD 256GB - Memory 8GB",
//            "Rp 3.120.000",
//            "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC0A\uD835\uDC00\uD835\uDC0D\uD835\uDC13\uD835\uDC0E\uD835\uDC11 \uD835\uDC08\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC0B\n" +
//                    "Cocok buat sekolah, kantor maupun rumahan\n" +
//                    "\n" +
//                    "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                    "✔ Cassing : Enlight - 120 /130\n" +
//                    "✔ Processor : Intel®️ Core™️ i3 2120\n" +
//                    "✔ Motherboard : H61\n" +
//                    "✔ Memory : PNY 8/16GB DDR3 1600\n" +
//                    "✔ SSD : 256GB\n" +
//                    "✔ Sound Card,Lan Card (Onboard)\n" +
//                    "✔ Monitor : LG 19\""),
//
//    Product(10, R.drawable.rakitan_intel10,
//            "PC / CPU / RAKITAN KOMPUTER CORE i5 BARU GARANSI 1 TAHUN - HDD500GB",
//            "Rp 1.925.000",
//            "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 :\n" +
//                    "\n" +
//                    "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC1A\uD835\uDC24\uD835\uDC22\uD835\uDC2D\uD835\uDC1A\uD835\uDC27 \uD835\uDC02\uD835\uDC28\uD835\uDC2B\uD835\uDC1E \uD835\uDC22\uD835\uDFD3 \uD835\uDC07\uD835\uDC1E\uD835\uDC26\uD835\uDC1A\uD835\uDC2D \uD835\uDC0C\uD835\uDC2E\uD835\uDC2B\uD835\uDC1A\uD835\uDC21 & \uD835\uDC01\uD835\uDC1E\uD835\uDC2B\uD835\uDC20\uD835\uDC1A\uD835\uDC2B\uD835\uDC1A\uD835\uDC27\uD835\uDC2C\uD835\uDC22 \uD835\uDFCF \uD835\uDC13\uD835\uDC1A\uD835\uDC21\uD835\uDC2E\uD835\uDC27\n" +
//                    "Spesifikasi ini Cocok Buat Keperluan Kantor Sekolah, Rumahan dan Kantor,\n" +
//                    "\n" +
//                    "belum bisa di pakai gaming dan editing render,untuk gaming dan render harus pakai vga lagi.\n" +
//                    "\n" +
//                    "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                    "✔ Motherboard Chipset Intel H61\n" +
//                    "✔ Intel Core i5 3470\n" +
//                    "✔ Memory DDR3 8GB PC 1600Mhz\n" +
//                    "✔ HDD Seagate 500GB Sata\n" +
//                    "✔ SSD 128/256 GB Sata (Pilih Varian)\n" +
//                    "✔ VGA Card Integrated Onboard\n" +
//                    "✔ Sound Card + Lan Card On Board\n" +
//                    "✔ Casing Dragon Slayer Black inc 3 Fan Red\n" +
//                    "✔ PSU Standard"),
//
//    Product(11, R.drawable.rakitan_amd_1,
//        "PC Gaming Ryzen 5 3600/GTX1050Ti 4GB/RAM 8GB 2400Mhz/HDD 500GB/WIFI",
//        "Rp 9.200.000",
//        "Pc Rakitan Gaming AMD Ryzen 5 terbaru , Semua Barang NEW & Garansi Resmi\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "Motherboard B450M\n" +
//                "Proc AMD Ryzen 5 3600\n" +
//                "Memory 2x4GB DDR4 2400Mhz\n" +
//                "Geforce GTX1050Ti 4GB DDR5\n" +
//                "HDD 500GB\n" +
//                "Sound Card + Lan Card On Board\n" +
//                "Casing Gaming innovation (include 1 x 12CM LED Rainbow Fan)\n" +
//                "PSU infinity 500W 80+\n" +
//                "WIFI Receiver include"),
//
//    Product(12, R.drawable.rakitan_amd_2,
//        "PC RAKITAN GAMING AMD | VGA RTX 3050 | SSD 256",
//        "Rp 11.455.000",
//        "\uD835\uDC0F\uD835\uDC02 \uD835\uDC11\uD835\uDC00\uD835\uDC0A\uD835\uDC08\uD835\uDC13\uD835\uDC00\uD835\uDC0D \uD835\uDC06\uD835\uDC00\uD835\uDC0C\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC00\uD835\uDC0C\uD835\uDC03\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "\uD835\uDC12\uD835\uDC29\uD835\uDC1E\uD835\uDC1C\uD835\uDC2C\uD835\uDC22\uD835\uDC1F\uD835\uDC22\uD835\uDC24\uD835\uDC1A\uD835\uDC2C\uD835\uDC22 \uD835\uDC0B\uD835\uDC1E\uD835\uDC27\uD835\uDC20\uD835\uDC24\uD835\uDC1A\uD835\uDC29 :\n" +
//                "✔ Cassing : INFINITY FLASH V2 (Tempered Glass, Include 1 Fan RGB)\n" +
//                "✔ Processor : AMD RYZEN 5 5500\n" +
//                "✔ Motherboard : MSI B450M PRO-VDH MAX\n" +
//                "✔ Memory : T-CREATE CLASSIC 2X8GB 3200\n" +
//                "✔ VGA : RTX 3050\n" +
//                "✔ SSD : PNY NVME GEN 3 256gb\n" +
//                "✔ HDD : SEAGATE 1TB ORI\n" +
//                "✔ PSU : INNOVATION 500W BRONZE\n" +
//                "✔ CPU Cooler : PARADOX HYPERSONIC (4 Chopper Pipe, ARGB)\n" +
//                "✔ Sound Card,Lan Card (Onboard)"),
//
//    Product(13, R.drawable.rakitan_amd_3,
//        "PC Design Ryzen 5 3600/ASUS A320M/RAM 8GB/HDD 500GB/R7 250",
//        "Rp 6.750.000",
//        "Pc Rakitan Ryzen 5 3600 Murah, Tidak Murahan & Garansi 1tahun\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "Spec PC :\n" +
//                "Motherboard ASUS A320M\n" +
//                "Proc AMD Ryzen 5 3600\n" +
//                "Memory TEAM DDR4 8GB (2x4GB) kit DDR4 2400Mhz\n" +
//                "VGA R7 250 2GB DDR5\n" +
//                "HDD 500GB\n" +
//                "Sound Card + Lan Card On Board\n" +
//                "Casing Gaming infinity Elysium/Cobra (inc 3 Fan 12cm Rainbow RGB)\n" +
//                "PSU Innovation / infinity 400W 80+ bronze\n" +
//                "Wifi Card include"),
//
//    Product(14, R.drawable.rakitan_amd_4,
//        "PC Gaming Ryzen 5 3600/GTX1660/RAM 16GB 2666Mhz/SSD 256GB/WIFI",
//        "Rp 14.850.000",
//        "Pc Rakitan Gaming AMD Ryzen 5 terbaru , Semua Barang NEW & Garansi Resmi\n" +
//                "Best Buy untuk Gaming, Editing dan Render\n" +
//                "\n" +
//                "Motherboard B450M\n" +
//                "Proc AMD Ryzen 5 3600\n" +
//                "Memory TEAM ELITE PLUS 2x8GB DDR4 2666Mhz\n" +
//                "Geforce GTX1660 6GB DDR6\n" +
//                "SSD 256GB TEAM\n" +
//                "Sound Card + Lan Card On Board\n" +
//                "Casing Gaming infinity Skyline (include 3 Fan Rainbow)\n" +
//                "PSU Enlight/Enermax 500W 80+\n" +
//                "WIFI Receiver include"),
//
//    Product(15, R.drawable.rakitan_amd_5,
//        "PC Gaming Ryzen 5 3600/ASUS A320M/RAM 16GB/SSD 240GB/ASUS RX550 4GB",
//        "Rp 9.470.000",
//        "Spec PC :\n" +
//                "Motherboard ASUS A320M\n" +
//                "Proc AMD Ryzen 5 3600\n" +
//                "Memory TEAM DDR4 16GB (2x8GB) kit DDR4 2400Mhz\n" +
//                "VGA ASUS RX550 4GB DDR5\n" +
//                "SSD 240GB + HDD 500GB\n" +
//                "Sound Card + Lan Card On Board\n" +
//                "Casing Gaming infinity Elysium/Cobra (inc 3 Fan 12cm Rainbow RGB)\n" +
//                "PSU infinity/innovation 500W 80+ bronze\n" +
//                "Wifi Card include"),
//)