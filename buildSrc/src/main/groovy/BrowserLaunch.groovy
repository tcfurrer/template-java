import org.gradle.api.DefaultTask
import java.nio.file.*
import org.gradle.api.GradleException
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.os.OperatingSystem

abstract class BrowserLaunch extends DefaultTask {
    @Input
    abstract Property<String> getHtmlFilePath()

    BrowserLaunch() {}

    @TaskAction
    def launch() {
        def htmlPath = Paths.get(htmlFilePath.get())
        if (!Files.isRegularFile(htmlPath) || !Files.isReadable(htmlPath))
            throw new GradleException("No such readable file: "+htmlPath);
        project.exec {
            if (OperatingSystem.current().isWindows()) {
                commandLine 'cmd', '/c', 'start', htmlPath
            } else {
                commandLine 'firefox', htmlPath
            }
        }
    }
}
