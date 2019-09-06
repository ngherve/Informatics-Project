using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class AddTask : System.Web.UI.Page
    {
        UserService.UserServiceClient client;
        User[] users = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserServiceClient();
            users = client.GetAllUsers();

            List<ListItem> items = new List<ListItem>();
            foreach (User u in users)
            {
                ListItem li = new ListItem(u.UserID.ToString(), u.UserID.ToString(), true);
                li.Text = u.UserID.ToString();
                li.Value = u.UserID.ToString();
                items.Add(li);
            }
            Towner.DataSource = items;
            Towner.DataBind();
        }

        protected void btnAddTask_Click(object sender, EventArgs e)
        {
            string owner = Towner.SelectedValue.ToString();
            DateTime currenttime = DateTime.Now;


            Task task = new Task
            {
                //UserID = Int32.Parse(Towner.SelectedValue),
                UserID = 3,
                TaskContent = "Outgoing Cable Ties",
                Start_Date = "2019/08/23",
                End_Date = "2019/08/24",
                //Priority = prty.SelectedItem.ToString(),
                Priority = "High",
                Status = "Pending",
                T_Type = "Outgoing"
            };

            string result = client.CreateTask(task);
            Response.Redirect("Tasks.aspx");

        }

        protected void btnCancelTask_Click(object sender, EventArgs e)
        {
            Response.Redirect("Tasks.aspx");
        }
    }
}