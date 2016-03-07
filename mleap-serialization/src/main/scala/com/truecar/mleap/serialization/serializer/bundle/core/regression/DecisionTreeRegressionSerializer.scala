package com.truecar.mleap.serialization.serializer.bundle.core.regression

import com.truecar.mleap.bundle.{Bundle, BundleSerializer}
import com.truecar.mleap.core.regression.DecisionTreeRegression
import com.truecar.mleap.core.tree.Node

/**
  * Created by hwilkins on 3/6/16.
  */
case class DecisionTreeRegressionSerializer(nodeSerializer: BundleSerializer[Node]) extends BundleSerializer[DecisionTreeRegression] {
  override val key: String = "ml.core.regression.DecisionTreeRegression"

  override def serialize(obj: DecisionTreeRegression, bundle: Bundle): Unit = {
    nodeSerializer.serialize(obj.rootNode, bundle.createBundle("rootNode"))
  }

  override def deserialize(bundle: Bundle): DecisionTreeRegression = {
    val rootNode = nodeSerializer.deserialize(bundle.getBundle("rootNode"))
    DecisionTreeRegression(rootNode)
  }
}
