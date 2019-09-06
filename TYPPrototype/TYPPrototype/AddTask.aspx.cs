﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
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
                    if (!u.User_Type.Equals("admin"))
                    {
                        ListItem li = new ListItem();
                        li.Text = u.UserID + " " + u.Name.ToString();
                        li.Value = u.UserID + " " + u.Name.ToString();
                        items.Add(li);
                    }
                }
                Towner.DataSource = items;
                Towner.DataBind();
            }
        }

        protected void btnAddTask_Click(object sender, EventArgs e)
        {
            owner = Towner.SelectedValue.ToString();
            owner = owner.Split(' ')[0];
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
            if (!client.GetUserbyID(task.UserID).User_Type.Equals("admin"))
            {
                var url = string.Format("http://localhost/script/send_push.php");
                using (var webClient = new WebClient())
                {
                    var response = webClient.DownloadString(url);
                    Console.WriteLine(response);
                }
            }
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