package com.kiber.comparemaster.function

import com.intellij.openapi.project.Project
import com.kiber.comparemaster.content.file.EFileTypes
import com.kiber.comparemaster.content.file.FilePair
import com.kiber.comparemaster.function.internal.ContentOperations


class CopyContentFunction : FilePairFunction {

    override fun apply(filePair: FilePair, project: Project) {
        ContentOperations.setText(filePair.leftText(false), filePair.right(), project)
    }

    override fun supports(fileType: EFileTypes): Boolean {
        return true
    }
}