import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream

fun main(args: Array<String>) {
    var tasks : ArrayList<Task> = arrayListOf()
    var myFile: File = File("")
    if (tasks.size == 0){println("На данный момент в списке задач нет.")}

    while (true)
    {
        println("Чтобы добавить задачу, нажмите 1, удалить - 2, просмотреть задачи - 3: ")
        var input = readLine()
        var doing = input?.toInt()

        if (doing == 1)
        {AddTask(tasks)}

        if (doing == 2)
        {DeleteTask(tasks)}

        if (doing == 3)
        {ReadTask(tasks)}
    }
}

fun AddTask( list : ArrayList<Task>): Boolean {
    println("Введите задачу: ")
    var fileWriter : FileWriter? = null
    return try
    {
        fileWriter = FileWriter("fileName", true)
        var newTask = readLine() ?: ""
        if (fileWriter != null) {fileWriter.write(newTask)}
        val newT: Task = Task(newTask)
        list.add(newT)
    }

    finally
    {
        fileWriter?.close()
        println("Задача добавлена!")
    }

}

fun ReadTask(list: ArrayList<Task>)
{
    File("fileName").forEachLine { println(it) }

    //for (task in list) {println(task.name)}
}

fun DeleteTask(list : ArrayList<Task>) {
   
    println("Какую задачу вы хотите удалить?")
    var line = readLine()
//    line.toString()

        var task: Task? = list.find { item -> line == item.name }
        list.remove(task)

    println("Задача удалена!")
}
