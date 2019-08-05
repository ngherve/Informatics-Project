using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class MasterPage : System.Web.UI.MasterPage
    {
        UserServiceClient userClient;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Username"] == null)
            {
                Response.Redirect("LoginUser.aspx");
            }
            else
            {
                
                userClient = new UserServiceClient();
                User[] users = userClient.GetAllUsers();
                foreach(User u in users)
                {
                    if(u.Username.Equals(Session["Username"].ToString()))
                    {
                        Session["UserID"] = u.UserID;
                    }
                }

                User user = userClient.GetUserbyID(int.Parse(Session["UserID"].ToString()));
                Session["UserEmail"] = user.Email;
                Session["UserType"] = user.User_Type;

                if(Session["UserType"].ToString()!="admin")
                {
                        AdminFunc2.Visible = false;
                        AdminFunc1.Visible= false;
                        AdminM.Visible = false;
                        AdminFunc1M.Visible = false;
                }

                if (Session["UserType"].ToString() != "admin")
                {
                    if (Session["UserType"].ToString() != "warehouse")
                    {
                        ware.Visible = false;
                        WareM.Visible = false;
                    }
                }
                if (Session["UserType"].ToString() != "admin")
                {
                    if (Session["UserType"].ToString() != "stock")
                    {
                        Prods.Visible = false;
                        ProdM.Visible = false;
                    }
                }

                EmployeeName.InnerHtml = user.Name.ToUpper();
                empImage.InnerHtml = "<img src='" + user.pphoto + "' alt='avatar'><i></i>";

                menuEdit.InnerHtml = "<a class='dropdown-item' href=UpdateUser.aspx?ID=" + user.UserID + "><i class='ft-user'></i> Edit Profile</a>" +
                                "<a class='dropdown-item' href='user-cards.html'><i class='ft-check-square'></i> Tasks</a>" +
                                "<div class='dropdown-divider'></div><a class='dropdown-item' href='logout.aspx'><i class='ft-power'></i> Logout</a>";
                viewNotification();
            }
        }

        public void viewNotification()
        {
            Notification[] notifs = userClient.GetNotifByUser(int.Parse(Session["UserID"].ToString()));
            string result = "";
            result += "<a class='nav-link nav-link-label' href='#' data-toggle='dropdown'><i class='material-icons'>notifications_none</i>" +
                        "<span class='badge badge-pill badge-danger badge-up badge-glow'>" + notifs.Length + "</span></a>" +
                        "<ul class='dropdown-menu dropdown-menu-media dropdown-menu-right'>" +
                        "<li class='dropdown-menu-header'>" +
                        "<h6 class='dropdown-header m-0'><span class='grey darken-2'>Notifications</span></h6><span class='notification-tag badge badge-danger float-right m-0'>" + notifs.Length + " New</span>";
            foreach(Notification n in notifs)
            {
                result += "<li class='scrollable-container media-list w-100'><a href = 'javascript:void(0)'>" +
                        "<div class='media'>" +
                        "<div class='media-left align-self-center'><i class='material-icons icon-bg-circle bg-cyan'>check_circle</i></div>" +
                        "<div class='media-body'>" +
                        "<h6 class='media-heading'>" + n.Message + "<br /><i>"+n.N_Email+"</i></h6><small>" +
                        "<time class='media-meta text-muted' datetime='2015-06-11T18:29:20+08:00'>" + n.N_Datetime + "</time></small>" +
                        "</div></div></a></li>";
            }
            result += "<li class='dropdown-menu-footer'><a class='dropdown-item text-muted text-center' href='javascript: void(0)'>Read all notifications</a></li></ul>";
            
            notlist.InnerHtml = result;
        }   
        
    }
}