name := "tasks"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-encoding", "utf8", "-target:jvm-1.8")

def log(v:String){
	println(s"${new java.util.Date()} $v")
}

val taskA = taskKey[String]("taskA")
val taskB = taskKey[String]("taskB")
val taskC = taskKey[String]("taskC")

taskA := { 
	log("start A")
	val b = taskB.value
	val c = taskC.value
	log("end A")
	"taskA" 
}
taskB := { 
	log("start B")
	Thread.sleep(5000)
	log("end B")
	"taskB"
}
taskC := {
	log("start C")
	Thread.sleep(5000)
	log("end C")
	"taskC"
}