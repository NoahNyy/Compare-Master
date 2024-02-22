package com.kiber.comparemaster.function

import com.intellij.openapi.project.Project
import com.kiber.comparemaster.content.file.FilePair
import com.kiber.comparemaster.content.parser.json.FilterStepsOperation
import com.kiber.comparemaster.content.parser.json.JsonPatchOperations
import com.kiber.comparemaster.function.internal.ContentOperations

class ReplaceOnlyPresentValuesFunction: JsonFilePairFunction {

    override fun apply(filePair: FilePair, project: Project) {
        //left is target
        //right is a source

        val source = filePair.rightDoc().text
        val target = filePair.leftDoc().text

        val result = JsonPatchOperations.toJsonPatch(source, target)
            .apply(FilterStepsOperation.filterOnlyPresentValues())
            .patchJson()

        ContentOperations.setText(result, filePair.right(), project)
    }
}