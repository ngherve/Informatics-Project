using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Script.Services;
using System.Web.Services;
using TYPPrototype.UserService;


namespace TYPPrototype
{
    public partial class EmployeeReport : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            GetChartData();
            getData();
        }

        private void getData()
        {
            UserServiceClient prodService;
            Task[] data;
            prodService = new UserServiceClient();

            data = prodService.GetTasks();

            string lowstock = "Suggestion: ";
            
            foreach(var i in data)
            {
                foreach (User u in prodService.GetAllUsers())
                {
                    if (i.UserID.Equals(u.UserID))
                    {
                        bool isdone = true;
                        foreach (var j in data)
                        {
                            if (!i.Status.Equals("done"))
                            {
                                isdone = false;
                            }
                        }
                        if(isdone) lowstock += u.Name.ToUpper() + " - ";
                    }
                }
            }
            if(!lowstock.Equals("Suggestion: "))
                lowstock += " completed all tasks(fastest) (:- should get the next jobs !!!";
            suggestiontask.InnerHtml = lowstock;
        }

        private static bool searchID(int id, List<int> ids)
        {
            foreach(int i in ids)
            {
                if (i == id)
                {
                    return true;
                }
            }
            return false;
        }
        
        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public static object[] GetChartData()
        {
            UserServiceClient userService;
            Task[] task;
            userService = new UserServiceClient();
            User[] users = userService.GetAllUsers();
            task = userService.GetTasks();
            List<Task> data = new List<Task>();
            data = task.ToList();

            var chartData = new object[task.Count() + 1];
            chartData[0] = new object[]
            {
                "Emp_Name: Task_Type",
                "Assigned Tasks",
                "Tasks Done"
            };
            int j = 0;
            List<int> us = new List<int>();
            foreach (var i in data)
            {
                foreach (User u in users)
                {
                    if (u.UserID.Equals(i.UserID))
                    {
                        us.Add(u.UserID);
                    }
                }
            }
            foreach (var i in data)
            {
                j++;
                foreach (User u in users)
                {
                    //task per user
                    int taskcount = 0;
                    foreach (Task t in task)
                    {
                        if (u.UserID.Equals(t.UserID))
                        {
                            taskcount++;
                        }
                    }

                    //tasks done per user
                    int donecount = 0;

                    foreach (Task t in task)
                    {
                        if (u.UserID.Equals(t.UserID) && t.Status.Equals("done"))
                        {
                            donecount++;
                        }
                    }

                    if (u.UserID.Equals(i.UserID)/* && !searchID(i.UserID, us)*/)
                    {
                        chartData[j] = new object[] { u.Name + ": " + i.T_Type + " task", taskcount, donecount };
                    }
                }                
            }
            return chartData;
        }
    }
}
