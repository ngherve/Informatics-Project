using System;
using System.Collections.Generic;
using System.Linq;
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
            List<User> ds = new List<User>();
            data = prodService.GetTasks();

            string lowstock = "Suggestion: ";

            foreach (User u in prodService.GetAllUsers())
            {
                bool isdone = true;
                foreach (var i in data)
                {
                    if (i.UserID.Equals(u.UserID))
                    {
                        if (!i.Status.Equals("done"))
                        {
                            isdone = false;
                        }
                        else if(isdone)
                        ds.Add(u);
                    }
                }
                
            }
            
            foreach(User usr in prodService.GetAllUsers())
            {

                foreach (User u in ds)
                {
                    if (usr.Name.Equals(u.Name))
                    {
                        lowstock += u.Name.ToUpper() + ", ";
                    }
                }
            }
                if (!lowstock.Equals("Suggestion: "))
                lowstock += " completed all tasks(fastest) (:- should get the next jobs !!!";
            suggestiontask.InnerHtml = lowstock;
        }

        private static bool searchID(int id, int[] ids)
        {
            bool retSearch = false;
            int count = 0;
            foreach(int i in ids)
            {
                if (i == id)
                {
                    count++;
                }
            }
            if (count > 1)
            {
                retSearch = true;
            }
            else
                retSearch = false;
            return retSearch;
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
            int[] us = new int[task.Length];
            //foreach (Task t in task)
            /*for(int i=0; i<task.Length; i++)
            {
                us[i] = task[i].UserID;    
            }*/
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
                    if (u.UserID.Equals(i.UserID))

                    {
                        chartData[j] = new object[] { u.Name + ": " + i.T_Type + " task", taskcount, donecount };
                    }
                }                
            }
            return chartData;
        }
    }
}
