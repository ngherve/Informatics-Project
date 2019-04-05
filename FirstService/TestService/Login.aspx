<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="TestService.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container">
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-3 mb-4"></div>
            <div class="col-lg-6 mb-4">
                <h2 class="form-signin-heading">Login</h2>
                <label  class="sr-only">User Name</label>
                 <div class="control-group form-group">
                    <div class="controls">
                        <label>Username:</label>
                        <input type="text" class="form-control" placeholder="James" runat="server" id="username" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Password:</label>
                        <input type="password" class="form-control" placeholder="**********" runat="server" id="password" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                </div>
                <asp:Button class="btn btn-lg btn-primary btn-block" type="submit" Text="Login" ID="btnLOgin" runat="server" OnClick="btnLOgin_Click"  />
                <div runat="server" id ="report"></div>
            </div>
        </div>

    </div>
</asp:Content>
