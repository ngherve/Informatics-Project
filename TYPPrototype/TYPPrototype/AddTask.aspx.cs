using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class AddTask : System.Web.UI.Page
    {
        UserService.UserServiceClient client;
        ProductService.ProductServiceClient pClient;
        User[] users = null;
        Product[] products = null;
        string owner = "";
        string pro = "";
        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserServiceClient();
            pClient = new ProductServiceClient();
            users = client.GetAllUsers();
            products = pClient.GetAllProducts();
            if (!IsPostBack)
            {
               
                List<ListItem> items = new List<ListItem>();
                List<ListItem> prods = new List<ListItem>();
                foreach (User u in users)
                {
                    if (!u.User_Type.Equals("admin"))
                    {
                        ListItem li = new ListItem();
                        li.Text = u.UserID + " " + u.Name.ToString() + "(" + u.User_Type + ")";
                        li.Value = u.UserID + " " + u.Name.ToString() + "(" + u.User_Type + ")";
                        items.Add(li);
                    }
                }
                Towner.DataSource = items;
                Towner.DataBind();

                foreach(Product p in products)
                {
                    ListItem x = new ListItem();
                    x.Text = p.P_ID +" "+ p.P_Name + " " +"Current Quantity="+" "+p.P_Quantity.ToString();
                    x.Value = p.P_ID.ToString();
                    
          
                    prods.Add(x);
                }
                ListItem newProd = new ListItem();
                newProd.Text = "New Incoming Product!!!";
                newProd.Text = "New Incoming Product!!!";
                prods.Add(newProd);
                ProList.DataSource = prods;
                ProList.DataBind();
            }
        }

        protected void btnAddTask_Click(object sender, EventArgs e)
        {
            owner = Towner.SelectedValue.ToString();
            owner = owner.Split(' ')[0];
            DateTime currenttime = DateTime.Now;
            pro = ProList.SelectedValue.ToString();
            if (pro.Equals("New Incoming Product!!!"))
            {
                string selec = (ttype.SelectedValue + " " + "Amount" + " " + Quantity.Value + " " + ProList.SelectedItem);

                Task task = new Task
                {
                    //UserID = Int32.Parse(Towner.SelectedValue),
                    UserID = int.Parse(owner),
                    TaskContent = selec,
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
            else
            {
                pro = pro.Split(' ')[0];
                Product sP = pClient.GetProductbyID(int.Parse(pro));
                if (!Quantity.Value.Equals(""))
                {

                    int q = int.Parse(Quantity.Value);


                    if (ttype.SelectedValue == "dispatch" && sP.P_Quantity < q)
                    {
                        error.InnerHtml = "Selected Quantity exceeds Stock!!";

                    }
                    else if (q <= 0)
                    {
                        error.InnerHtml = "Invalid Quantity !!";
                    }
                    else
                    {
                        string selec = (ttype.SelectedValue + " " + "Amount" + " " + Quantity.Value + " " + ProList.SelectedItem);

                        Task task = new Task
                        {
                            //UserID = Int32.Parse(Towner.SelectedValue),
                            UserID = int.Parse(owner),
                            TaskContent = selec,
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
                }
                else
                {
                    error.InnerHtml = "Enter a Quantity!!";
                }
            }
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