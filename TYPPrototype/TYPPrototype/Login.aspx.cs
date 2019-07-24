﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using MySql.Data.MySqlClient;
using System.Net;
using System.Web.Script.Serialization;
using System.Text;

namespace TYPPrototype
{
    public partial class LoginUser : System.Web.UI.Page
    {
        UserService.UserServiceClient client;

        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserService.UserServiceClient();
        }
        protected void btnLogin_Click(object sender, EventArgs e)
        {
            string usernam = username.Value;
            string Password = userpassword.Value;
           
            if (Session["Username"] == null)
            {
                if(client.LoginUser(usernam, Password) == true)
                {
                    Session["Username"] = usernam;
                    Response.Redirect("index.aspx");
                }
                else
                {
                    error.InnerHtml = "Error: Invalid Credentials";
                    Session["Username"] = null;
                }
            }else if (Session["Username"].Equals(usernam))
            {
                Response.Write("<script>alert('" + "You are Already Logged In" + "')</script>");
            }
        }
    }
}