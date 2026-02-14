rootProject.name = "net.thaumtale.kweebecgoddess"

plugins {
    id("dev.scaffoldit") version "0.2.9"
}


hytale {
    usePatchline("pre-release")
    useVersion("latest")

    repositories {
        // Any external repositories besides: MavenLocal, MavenCentral, HytaleMaven, and CurseMaven
    }

    dependencies {
        // Any external dependency you also want to include
    }

    manifest {
        Group = "ThaumicAddons"
        Name = "KweebecGoddess"
        Main = "net.thaumtale.kweebecgoddess.KweebecGoddess"
    }
}
