package runner

import io.gatling.app.Gatling

object GatlingRunnerWrapper {

    def main(args: Array[String]): Unit = {
      java.nio.file.FileSystems.getDefault()
      Gatling.main(args)
    }
}
