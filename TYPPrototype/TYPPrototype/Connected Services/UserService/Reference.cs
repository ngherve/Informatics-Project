﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace TYPPrototype.UserService {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="User", Namespace="http://schemas.datacontract.org/2004/07/WirelecWCFService")]
    [System.SerializableAttribute()]
    public partial class User : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string AddressField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string DOBField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string EmailField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string GenderField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string NameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string PasswordField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string Tel_NumberField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int UserIDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string User_TypeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string UsernameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string pphotoField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Address {
            get {
                return this.AddressField;
            }
            set {
                if ((object.ReferenceEquals(this.AddressField, value) != true)) {
                    this.AddressField = value;
                    this.RaisePropertyChanged("Address");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string DOB {
            get {
                return this.DOBField;
            }
            set {
                if ((object.ReferenceEquals(this.DOBField, value) != true)) {
                    this.DOBField = value;
                    this.RaisePropertyChanged("DOB");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Email {
            get {
                return this.EmailField;
            }
            set {
                if ((object.ReferenceEquals(this.EmailField, value) != true)) {
                    this.EmailField = value;
                    this.RaisePropertyChanged("Email");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Gender {
            get {
                return this.GenderField;
            }
            set {
                if ((object.ReferenceEquals(this.GenderField, value) != true)) {
                    this.GenderField = value;
                    this.RaisePropertyChanged("Gender");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Name {
            get {
                return this.NameField;
            }
            set {
                if ((object.ReferenceEquals(this.NameField, value) != true)) {
                    this.NameField = value;
                    this.RaisePropertyChanged("Name");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Password {
            get {
                return this.PasswordField;
            }
            set {
                if ((object.ReferenceEquals(this.PasswordField, value) != true)) {
                    this.PasswordField = value;
                    this.RaisePropertyChanged("Password");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Tel_Number {
            get {
                return this.Tel_NumberField;
            }
            set {
                if ((object.ReferenceEquals(this.Tel_NumberField, value) != true)) {
                    this.Tel_NumberField = value;
                    this.RaisePropertyChanged("Tel_Number");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int UserID {
            get {
                return this.UserIDField;
            }
            set {
                if ((this.UserIDField.Equals(value) != true)) {
                    this.UserIDField = value;
                    this.RaisePropertyChanged("UserID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string User_Type {
            get {
                return this.User_TypeField;
            }
            set {
                if ((object.ReferenceEquals(this.User_TypeField, value) != true)) {
                    this.User_TypeField = value;
                    this.RaisePropertyChanged("User_Type");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Username {
            get {
                return this.UsernameField;
            }
            set {
                if ((object.ReferenceEquals(this.UsernameField, value) != true)) {
                    this.UsernameField = value;
                    this.RaisePropertyChanged("Username");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string pphoto {
            get {
                return this.pphotoField;
            }
            set {
                if ((object.ReferenceEquals(this.pphotoField, value) != true)) {
                    this.pphotoField = value;
                    this.RaisePropertyChanged("pphoto");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Notification", Namespace="http://schemas.datacontract.org/2004/07/WirelecWCFService")]
    [System.SerializableAttribute()]
    public partial class Notification : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string MessageField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string N_DatetimeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string N_EmailField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int N_IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int UserIDField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Message {
            get {
                return this.MessageField;
            }
            set {
                if ((object.ReferenceEquals(this.MessageField, value) != true)) {
                    this.MessageField = value;
                    this.RaisePropertyChanged("Message");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string N_Datetime {
            get {
                return this.N_DatetimeField;
            }
            set {
                if ((object.ReferenceEquals(this.N_DatetimeField, value) != true)) {
                    this.N_DatetimeField = value;
                    this.RaisePropertyChanged("N_Datetime");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string N_Email {
            get {
                return this.N_EmailField;
            }
            set {
                if ((object.ReferenceEquals(this.N_EmailField, value) != true)) {
                    this.N_EmailField = value;
                    this.RaisePropertyChanged("N_Email");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int N_ID {
            get {
                return this.N_IDField;
            }
            set {
                if ((this.N_IDField.Equals(value) != true)) {
                    this.N_IDField = value;
                    this.RaisePropertyChanged("N_ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int UserID {
            get {
                return this.UserIDField;
            }
            set {
                if ((this.UserIDField.Equals(value) != true)) {
                    this.UserIDField = value;
                    this.RaisePropertyChanged("UserID");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Task", Namespace="http://schemas.datacontract.org/2004/07/WirelecWCFService")]
    [System.SerializableAttribute()]
    public partial class Task : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string End_DateField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string PriorityField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string Start_DateField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string StatusField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string T_TypeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string TaskContentField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int Task_IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int UserIDField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string End_Date {
            get {
                return this.End_DateField;
            }
            set {
                if ((object.ReferenceEquals(this.End_DateField, value) != true)) {
                    this.End_DateField = value;
                    this.RaisePropertyChanged("End_Date");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Priority {
            get {
                return this.PriorityField;
            }
            set {
                if ((object.ReferenceEquals(this.PriorityField, value) != true)) {
                    this.PriorityField = value;
                    this.RaisePropertyChanged("Priority");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Start_Date {
            get {
                return this.Start_DateField;
            }
            set {
                if ((object.ReferenceEquals(this.Start_DateField, value) != true)) {
                    this.Start_DateField = value;
                    this.RaisePropertyChanged("Start_Date");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Status {
            get {
                return this.StatusField;
            }
            set {
                if ((object.ReferenceEquals(this.StatusField, value) != true)) {
                    this.StatusField = value;
                    this.RaisePropertyChanged("Status");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string T_Type {
            get {
                return this.T_TypeField;
            }
            set {
                if ((object.ReferenceEquals(this.T_TypeField, value) != true)) {
                    this.T_TypeField = value;
                    this.RaisePropertyChanged("T_Type");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string TaskContent {
            get {
                return this.TaskContentField;
            }
            set {
                if ((object.ReferenceEquals(this.TaskContentField, value) != true)) {
                    this.TaskContentField = value;
                    this.RaisePropertyChanged("TaskContent");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int Task_ID {
            get {
                return this.Task_IDField;
            }
            set {
                if ((this.Task_IDField.Equals(value) != true)) {
                    this.Task_IDField = value;
                    this.RaisePropertyChanged("Task_ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int UserID {
            get {
                return this.UserIDField;
            }
            set {
                if ((this.UserIDField.Equals(value) != true)) {
                    this.UserIDField = value;
                    this.RaisePropertyChanged("UserID");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="UserService.IUserService")]
    public interface IUserService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetAllUsers", ReplyAction="http://tempuri.org/IUserService/GetAllUsersResponse")]
        TYPPrototype.UserService.User[] GetAllUsers();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetAllUsers", ReplyAction="http://tempuri.org/IUserService/GetAllUsersResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.User[]> GetAllUsersAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetNotifications", ReplyAction="http://tempuri.org/IUserService/GetNotificationsResponse")]
        TYPPrototype.UserService.Notification[] GetNotifications();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetNotifications", ReplyAction="http://tempuri.org/IUserService/GetNotificationsResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.Notification[]> GetNotificationsAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetTasks", ReplyAction="http://tempuri.org/IUserService/GetTasksResponse")]
        TYPPrototype.UserService.Task[] GetTasks();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetTasks", ReplyAction="http://tempuri.org/IUserService/GetTasksResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.Task[]> GetTasksAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetUserbyID", ReplyAction="http://tempuri.org/IUserService/GetUserbyIDResponse")]
        TYPPrototype.UserService.User GetUserbyID(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetUserbyID", ReplyAction="http://tempuri.org/IUserService/GetUserbyIDResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.User> GetUserbyIDAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetNotifByUser", ReplyAction="http://tempuri.org/IUserService/GetNotifByUserResponse")]
        TYPPrototype.UserService.Notification[] GetNotifByUser(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/GetNotifByUser", ReplyAction="http://tempuri.org/IUserService/GetNotifByUserResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.Notification[]> GetNotifByUserAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/RegisterUser", ReplyAction="http://tempuri.org/IUserService/RegisterUserResponse")]
        string RegisterUser(TYPPrototype.UserService.User user);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/RegisterUser", ReplyAction="http://tempuri.org/IUserService/RegisterUserResponse")]
        System.Threading.Tasks.Task<string> RegisterUserAsync(TYPPrototype.UserService.User user);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/SaveNotif", ReplyAction="http://tempuri.org/IUserService/SaveNotifResponse")]
        string SaveNotif(TYPPrototype.UserService.Notification notif);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/SaveNotif", ReplyAction="http://tempuri.org/IUserService/SaveNotifResponse")]
        System.Threading.Tasks.Task<string> SaveNotifAsync(TYPPrototype.UserService.Notification notif);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/CreateTask", ReplyAction="http://tempuri.org/IUserService/CreateTaskResponse")]
        string CreateTask(TYPPrototype.UserService.Task task);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/CreateTask", ReplyAction="http://tempuri.org/IUserService/CreateTaskResponse")]
        System.Threading.Tasks.Task<string> CreateTaskAsync(TYPPrototype.UserService.Task task);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/LoginUser", ReplyAction="http://tempuri.org/IUserService/LoginUserResponse")]
        bool LoginUser(string username, string password);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/LoginUser", ReplyAction="http://tempuri.org/IUserService/LoginUserResponse")]
        System.Threading.Tasks.Task<bool> LoginUserAsync(string username, string password);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/DeleteUser", ReplyAction="http://tempuri.org/IUserService/DeleteUserResponse")]
        string DeleteUser(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/DeleteUser", ReplyAction="http://tempuri.org/IUserService/DeleteUserResponse")]
        System.Threading.Tasks.Task<string> DeleteUserAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/SearchUser", ReplyAction="http://tempuri.org/IUserService/SearchUserResponse")]
        TYPPrototype.UserService.User SearchUser(string name);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/SearchUser", ReplyAction="http://tempuri.org/IUserService/SearchUserResponse")]
        System.Threading.Tasks.Task<TYPPrototype.UserService.User> SearchUserAsync(string name);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/UpdateUser", ReplyAction="http://tempuri.org/IUserService/UpdateUserResponse")]
        string UpdateUser(TYPPrototype.UserService.User user);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/UpdateUser", ReplyAction="http://tempuri.org/IUserService/UpdateUserResponse")]
        System.Threading.Tasks.Task<string> UpdateUserAsync(TYPPrototype.UserService.User user);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IUserServiceChannel : TYPPrototype.UserService.IUserService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class UserServiceClient : System.ServiceModel.ClientBase<TYPPrototype.UserService.IUserService>, TYPPrototype.UserService.IUserService {
        
        public UserServiceClient() {
        }
        
        public UserServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public UserServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UserServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UserServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public TYPPrototype.UserService.User[] GetAllUsers() {
            return base.Channel.GetAllUsers();
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.User[]> GetAllUsersAsync() {
            return base.Channel.GetAllUsersAsync();
        }
        
        public TYPPrototype.UserService.Notification[] GetNotifications() {
            return base.Channel.GetNotifications();
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.Notification[]> GetNotificationsAsync() {
            return base.Channel.GetNotificationsAsync();
        }
        
        public TYPPrototype.UserService.Task[] GetTasks() {
            return base.Channel.GetTasks();
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.Task[]> GetTasksAsync() {
            return base.Channel.GetTasksAsync();
        }
        
        public TYPPrototype.UserService.User GetUserbyID(int id) {
            return base.Channel.GetUserbyID(id);
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.User> GetUserbyIDAsync(int id) {
            return base.Channel.GetUserbyIDAsync(id);
        }
        
        public TYPPrototype.UserService.Notification[] GetNotifByUser(int id) {
            return base.Channel.GetNotifByUser(id);
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.Notification[]> GetNotifByUserAsync(int id) {
            return base.Channel.GetNotifByUserAsync(id);
        }
        
        public string RegisterUser(TYPPrototype.UserService.User user) {
            return base.Channel.RegisterUser(user);
        }
        
        public System.Threading.Tasks.Task<string> RegisterUserAsync(TYPPrototype.UserService.User user) {
            return base.Channel.RegisterUserAsync(user);
        }
        
        public string SaveNotif(TYPPrototype.UserService.Notification notif) {
            return base.Channel.SaveNotif(notif);
        }
        
        public System.Threading.Tasks.Task<string> SaveNotifAsync(TYPPrototype.UserService.Notification notif) {
            return base.Channel.SaveNotifAsync(notif);
        }
        
        public string CreateTask(TYPPrototype.UserService.Task task) {
            return base.Channel.CreateTask(task);
        }
        
        public System.Threading.Tasks.Task<string> CreateTaskAsync(TYPPrototype.UserService.Task task) {
            return base.Channel.CreateTaskAsync(task);
        }
        
        public bool LoginUser(string username, string password) {
            return base.Channel.LoginUser(username, password);
        }
        
        public System.Threading.Tasks.Task<bool> LoginUserAsync(string username, string password) {
            return base.Channel.LoginUserAsync(username, password);
        }
        
        public string DeleteUser(int id) {
            return base.Channel.DeleteUser(id);
        }
        
        public System.Threading.Tasks.Task<string> DeleteUserAsync(int id) {
            return base.Channel.DeleteUserAsync(id);
        }
        
        public TYPPrototype.UserService.User SearchUser(string name) {
            return base.Channel.SearchUser(name);
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.UserService.User> SearchUserAsync(string name) {
            return base.Channel.SearchUserAsync(name);
        }
        
        public string UpdateUser(TYPPrototype.UserService.User user) {
            return base.Channel.UpdateUser(user);
        }
        
        public System.Threading.Tasks.Task<string> UpdateUserAsync(TYPPrototype.UserService.User user) {
            return base.Channel.UpdateUserAsync(user);
        }
    }
}
