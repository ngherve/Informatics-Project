using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;
namespace TYPPrototype
{
    public partial class Tasks : System.Web.UI.Page
    {
        
        UserServiceClient userService;
        protected void Page_Load(object sender, EventArgs e)
        {
            userService = new UserServiceClient();
            Task[] tasks = userService.GetTasks();

            string display = "";

            foreach (Task task in tasks)
            {
                User u = userService.GetUserbyID(task.UserID);
                display += "<tr>"
                        + "<td><input type='checkbox' class='input-chk'></td>"
                        + "<td>"
                        + "<p class='text-muted'>" + task.TaskContent + "</p>"
                        + "</td>"
                        + "<td><span class='badge badge-primary'>" + task.Start_Date + "</span></td>"
                        + "<td><span class='badge badge-danger'>" + task.Priority + "</span></td>"
                        + "<td><span class='badge badge-primary'>" + task.Status + "</span></td>"
                        + "<td class='text-center'>"
                        + "<span class='avatar avatar-busy'>"
                        + "<img src='"+ u.pphoto +"' alt='avatar' data-toggle='tooltip' data-placement='right' title='"+ u.Name +"'><i class=''></i>"
                        + "</span></td>"
                        + "<td>"
                        + "<div class='dropdown'>"
                        + "<button id='btnSearchDrop2' type='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false' class='btn btn-info dropdown-toggle'><i class='la la-cog align-middle'></i></button>"
                        + "<div aria-labelledby='btnSearchDrop2' class='dropdown-menu mt-1 dropdown-menu-right'>"
                        + "<a href='#' class='dropdown-item'><i class='ft-upload'></i> Assign to</a>"
                        + "<div class='dropdown-divider'></div>"
                        + " <a href=DeleteTask.aspx?ID=" + task.Task_ID + " class='dropdown-item'><i class='ft-trash'></i> Delete Task</a>"
                        + " </div>"
                        + " </div>"
                        + " </td>"
                        + "</tbody>"
                        ;
            }
            //tasklist.InnerHtml = display;
            tablebody.InnerHtml = display;

        }

        public void UpdateTask(int taskid, int userID)
        {
            string mycon = "server =localhost; Uid=root; password = ; " +
             "persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True";
            MySqlConnection connection = new MySqlConnection(mycon);

            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "UPDATE Task SET UserID = '" + userID
                + "'WHERE Task_ID = '" + taskid + "'";
            cmd.ExecuteNonQuery();
        }

        protected void btnNewTask_Click(object sender, EventArgs e)
        {
            Response.Redirect("AddTask.aspx");
        }
    }
}