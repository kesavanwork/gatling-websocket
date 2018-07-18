package environment

import java.io.{File, FileInputStream}


import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

object Environment {

  val fileStream = new FileInputStream(new File(getClass.getResource("/config/params.yml").getPath))
  val environment = new Yaml(new Constructor(classOf[Environments])).load(fileStream).asInstanceOf[Environments]
  fileStream.close()

  def currentEnvironment: Environment = {


    val targetEnvironment: String = System.getProperty("targetEnvironment")


    if (targetEnvironment == null) {
      throw new IllegalArgumentException("Target environment should be provided")
    }
    environment.environments.get(targetEnvironment)
  }
}
