package environment

import java.io.{File, FileInputStream}

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

object Param {

  val fileStream = new FileInputStream(new File(getClass.getResource("/config/params.yml").getPath))
  val param = new Yaml(new Constructor(classOf[ParamEnvironments])).load(fileStream).asInstanceOf[ParamEnvironments]
  fileStream.close()

  def currentEnvironment: ParamEnvironment = {


    val targetEnvironment: String = System.getProperty("targetEnvironment")


    if (targetEnvironment == null) {
      throw new IllegalArgumentException("Target environment should be provided")
    }
    param.paramEnvironments.get(targetEnvironment)
  }
}
