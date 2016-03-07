package com.truecar.mleap.bundle

/**
  * Created by hwilkins on 3/4/16.
  */
trait BundleSerializer[Obj] {
  val key: String

  def serializeAny(obj: Any, bundle: Bundle): Unit = serialize(obj.asInstanceOf[Obj], bundle)
  def deserializeAny(bundle: Bundle): Any = deserialize(bundle)

  def serialize(obj: Obj, bundle: Bundle): Unit
  def deserialize(bundle: Bundle): Obj
}
