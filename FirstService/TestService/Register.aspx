<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="TestService.Register" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container">
        <br />
        <br />
        <br />
        <br />
        <div class="row">
            <div class="col-lg-3 mb-4"></div>
            <div class="col-lg-6 mb-4">
                <h4 class="card-header">Register New User</h4>
                <br />
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Title:</label>
                        <input type="text" class="form-control" placeholder="Mr." runat="server" id="title" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Name:</label>
                        <input type="text" class="form-control" placeholder="James" runat="server" id="name" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Surname:</label>
                        <input type="text" class="form-control" placeholder="Gordon" runat="server" id="surname" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>

                <div class="control-group form-group">
                    <div class="controls">
                        <label>Email:</label>
                        <input type="email" class="form-control" placeholder="James@gpd.dc" runat="server" id="email" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>

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
                
                  <div class="control-group form-group">
                    <div class="controls">
                        <label>Confirm Password:</label>
                        <input type="password" class="form-control" placeholder="**********" runat="server" id="password1" required autofocus>
                        <p class="help-block"></p>
                    </div>
                </div>
                <asp:Button class="btn btn-lg btn-primary btn-block" type="submit" Text="Register" ID="btnReg" runat="server" OnClick="btnReg_Click" />
                <div runat="server" id ="report"></div>
            </div>
        </div>
        <br />
        <br />
        <br />
    </div>
</asp:Content>
