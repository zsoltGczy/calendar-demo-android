package com.gzslt.calendardemo.data.mapper.api.todatabase

import com.gzslt.calendardemo.data.api.BaseApiModel
import com.gzslt.calendardemo.data.database.BaseDataModel
import com.gzslt.calendardemo.data.mapper.BaseMapper

abstract class ApiModelToDataModelMapper<T : BaseApiModel, R : BaseDataModel> : BaseMapper<T, R>()
