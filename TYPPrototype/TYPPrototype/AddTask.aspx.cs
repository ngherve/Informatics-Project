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
        string owner = "";
        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserServiceClient();
            users = client.GetAllUsers();

            if (!IsPostBack)
            {
               
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
        }

        protected void btnAddTask_Click(object sender, EventArgs e)
        {
            owner = Towner.SelectedValue.ToString();
            DateTime currenttime = DateTime.Now;


            Task task = new Task
            {
                //UserID = Int32.Parse(Towner.SelectedValue),
                UserID = int.Parse(owner),
                TaskContent = Tdesc.Value,
                Start_Date = currenttime.ToString(),
                End_Date = "",
                //Priority = prty.SelectedItem.ToString(),
                Priority = prty.SelectedValue,
                Status = "pending",
                T_Type = ttype.SelectedValue
            };

            string result = client.CreateTask(task);
            Response.Redirect("Tasks.aspx");

        }

        protected void btnCancelTask_Click(object sender, EventArgs e)
        {
            Response.Redirect("Tasks.aspx");
        }

        protected void Towner_SelectedIndexChanged(object sender, EventArgs e)
        {
            owner = Towner.SelectedValue;
        }
    }
}