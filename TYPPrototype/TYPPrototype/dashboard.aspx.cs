using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;
using TYPPrototype.ProductService;
using System.Web.Services;
using System.Web.Script.Services;

namespace TYPPrototype
{
    public partial class dashboard : System.Web.UI.Page
    {

        UserServiceClient userClient;
        ProductServiceClient prodClient;

        protected void Page_Load(object sender, EventArgs e)
        {

            userClient = new UserServiceClient();
            prodClient = new ProductServiceClient();

            tasks.InnerHtml = userClient.GetTasks().Length.ToString();
            users.InnerHtml = userClient.GetAllUsers().Length.ToString();

            int incomingcount = 0;
            int outgoingcount = 0;
            Invoice[] invs = prodClient.GetAllInvoices();
            foreach (Invoice inv in invs)
            {
                if (inv.Inv_Type.Equals("incoming"))
                {
                    incomingcount += inv.Quantity;
                } else if (inv.Inv_Type.Equals("dispatch"))
                {
                    outgoingcount += inv.Quantity;
                }
            }

            string display = " ";

            Invoice[] invoices = prodClient.GetInvoicebyType("dispatch");
            foreach(Invoice inv in invoices)
            {
                Product pro = prodClient.SearchProduct(inv.P_Code);
                User u = userClient.GetUserbyID(inv.UserID);
                display += "<tr>"
                        + "<td class='text-truncate'>" + pro.P_Name + " " + inv.P_Code + "</td>"
                        + "<td class='text-truncate p-1'>"
                        + "<ul class='list-unstyled users-list m-0'>"
                        + "<li><span class='avatar avatar-busy'>"
                        + "<img src='"+ u.pphoto +"' alt='avatar' data-toggle='tooltip' data-placement='right' title='"+ u.Name +"'><i class=''></i>"
                        + "</span></li>"
                        + "</ul>"
                        + "</td>"
                        + "<td class='text-truncate'>"+inv.Quantity+"</td> "
                        + "<td class='text-truncate'>" + inv.INV_Date + "</td> "
                        + "</tr>"
                        ;
            }
            ordertable.InnerHtml = display;
            incoming.InnerHtml = incomingcount.ToString();
            outgoing.InnerHtml = outgoingcount.ToString();
            GetChartData();
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

                    foreach (Task t in task)
                    {
                        if (u.UserID.Equals(i.UserID))
                        {
                            chartData[j] = new object[] { u.Name + ": " + i.T_Type + " task", taskcount, donecount };
                        }
                    }
                }
            }
            return chartData;
        }
    }
}