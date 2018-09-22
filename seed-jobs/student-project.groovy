pipelineJob('StudentProj-CI') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelines/StudentProjCI.groovy'))
            sandbox()
        }
    }
}