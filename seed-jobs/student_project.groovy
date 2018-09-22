pipelineJob('StudentProj-CI') {
    definition {
        cps {
            script(readFileFromWorkspace('sample.groovy'))
            sandbox()
        }
    }
}