package com.gzslt.calendardemo.data.mapper.database.toPresentation

import com.gzslt.calendardemo.data.database.BaseTuple
import com.gzslt.calendardemo.data.mapper.BaseMapper
import com.gzslt.calendardemo.model.BasePresentationModel

abstract class TupleToPresentationModelMapper<T : BaseTuple, R : BasePresentationModel> :
    BaseMapper<T, R>()
