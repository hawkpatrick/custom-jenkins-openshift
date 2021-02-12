pipelineJob('Build-Pipeline') {
    parameters {
        booleanParam('skipTests', true)
    }
    definition {
        cpsScm {
            scm {
                git {
                    branch('*/master')
                    remote {
                        url('https://github.com/hawkpatrick/sample-java-project.git')
                    }
                    extensions {}
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
    concurrentBuild(false)
    configure {
        it / definition / lightweight(true)
    }
    logRotator {
        daysToKeep(0)
        daysToKeep(1)
    }

}

