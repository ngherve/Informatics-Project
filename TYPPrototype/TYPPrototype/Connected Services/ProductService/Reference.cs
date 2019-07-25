﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace TYPPrototype.ProductService {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Product", Namespace="http://schemas.datacontract.org/2004/07/WirelecWCFService")]
    [System.SerializableAttribute()]
    public partial class Product : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string P_CodeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int P_IDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string P_ImageField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string P_NameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int P_PriceField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int P_QuantityField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string P_TypeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string Supplier_NameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string W_NameField;
        
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
        public string P_Code {
            get {
                return this.P_CodeField;
            }
            set {
                if ((object.ReferenceEquals(this.P_CodeField, value) != true)) {
                    this.P_CodeField = value;
                    this.RaisePropertyChanged("P_Code");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int P_ID {
            get {
                return this.P_IDField;
            }
            set {
                if ((this.P_IDField.Equals(value) != true)) {
                    this.P_IDField = value;
                    this.RaisePropertyChanged("P_ID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string P_Image {
            get {
                return this.P_ImageField;
            }
            set {
                if ((object.ReferenceEquals(this.P_ImageField, value) != true)) {
                    this.P_ImageField = value;
                    this.RaisePropertyChanged("P_Image");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string P_Name {
            get {
                return this.P_NameField;
            }
            set {
                if ((object.ReferenceEquals(this.P_NameField, value) != true)) {
                    this.P_NameField = value;
                    this.RaisePropertyChanged("P_Name");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int P_Price {
            get {
                return this.P_PriceField;
            }
            set {
                if ((this.P_PriceField.Equals(value) != true)) {
                    this.P_PriceField = value;
                    this.RaisePropertyChanged("P_Price");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int P_Quantity {
            get {
                return this.P_QuantityField;
            }
            set {
                if ((this.P_QuantityField.Equals(value) != true)) {
                    this.P_QuantityField = value;
                    this.RaisePropertyChanged("P_Quantity");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string P_Type {
            get {
                return this.P_TypeField;
            }
            set {
                if ((object.ReferenceEquals(this.P_TypeField, value) != true)) {
                    this.P_TypeField = value;
                    this.RaisePropertyChanged("P_Type");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string Supplier_Name {
            get {
                return this.Supplier_NameField;
            }
            set {
                if ((object.ReferenceEquals(this.Supplier_NameField, value) != true)) {
                    this.Supplier_NameField = value;
                    this.RaisePropertyChanged("Supplier_Name");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string W_Name {
            get {
                return this.W_NameField;
            }
            set {
                if ((object.ReferenceEquals(this.W_NameField, value) != true)) {
                    this.W_NameField = value;
                    this.RaisePropertyChanged("W_Name");
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
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ProductService.IProductService")]
    public interface IProductService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/GetAllProducts", ReplyAction="http://tempuri.org/IProductService/GetAllProductsResponse")]
        TYPPrototype.ProductService.Product[] GetAllProducts();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/GetAllProducts", ReplyAction="http://tempuri.org/IProductService/GetAllProductsResponse")]
        System.Threading.Tasks.Task<TYPPrototype.ProductService.Product[]> GetAllProductsAsync();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/GetProductbyID", ReplyAction="http://tempuri.org/IProductService/GetProductbyIDResponse")]
        TYPPrototype.ProductService.Product GetProductbyID(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/GetProductbyID", ReplyAction="http://tempuri.org/IProductService/GetProductbyIDResponse")]
        System.Threading.Tasks.Task<TYPPrototype.ProductService.Product> GetProductbyIDAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/DeleteProduct", ReplyAction="http://tempuri.org/IProductService/DeleteProductResponse")]
        string DeleteProduct(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/DeleteProduct", ReplyAction="http://tempuri.org/IProductService/DeleteProductResponse")]
        System.Threading.Tasks.Task<string> DeleteProductAsync(int id);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/SearchProduct", ReplyAction="http://tempuri.org/IProductService/SearchProductResponse")]
        TYPPrototype.ProductService.Product SearchProduct(string name);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/SearchProduct", ReplyAction="http://tempuri.org/IProductService/SearchProductResponse")]
        System.Threading.Tasks.Task<TYPPrototype.ProductService.Product> SearchProductAsync(string name);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/AddProduct", ReplyAction="http://tempuri.org/IProductService/AddProductResponse")]
        string AddProduct(TYPPrototype.ProductService.Product product);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/AddProduct", ReplyAction="http://tempuri.org/IProductService/AddProductResponse")]
        System.Threading.Tasks.Task<string> AddProductAsync(TYPPrototype.ProductService.Product product);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/UpdateProduct", ReplyAction="http://tempuri.org/IProductService/UpdateProductResponse")]
        string UpdateProduct(TYPPrototype.ProductService.Product product);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IProductService/UpdateProduct", ReplyAction="http://tempuri.org/IProductService/UpdateProductResponse")]
        System.Threading.Tasks.Task<string> UpdateProductAsync(TYPPrototype.ProductService.Product product);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IProductServiceChannel : TYPPrototype.ProductService.IProductService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ProductServiceClient : System.ServiceModel.ClientBase<TYPPrototype.ProductService.IProductService>, TYPPrototype.ProductService.IProductService {
        
        public ProductServiceClient() {
        }
        
        public ProductServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ProductServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProductServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProductServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public TYPPrototype.ProductService.Product[] GetAllProducts() {
            return base.Channel.GetAllProducts();
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.ProductService.Product[]> GetAllProductsAsync() {
            return base.Channel.GetAllProductsAsync();
        }
        
        public TYPPrototype.ProductService.Product GetProductbyID(int id) {
            return base.Channel.GetProductbyID(id);
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.ProductService.Product> GetProductbyIDAsync(int id) {
            return base.Channel.GetProductbyIDAsync(id);
        }
        
        public string DeleteProduct(int id) {
            return base.Channel.DeleteProduct(id);
        }
        
        public System.Threading.Tasks.Task<string> DeleteProductAsync(int id) {
            return base.Channel.DeleteProductAsync(id);
        }
        
        public TYPPrototype.ProductService.Product SearchProduct(string name) {
            return base.Channel.SearchProduct(name);
        }
        
        public System.Threading.Tasks.Task<TYPPrototype.ProductService.Product> SearchProductAsync(string name) {
            return base.Channel.SearchProductAsync(name);
        }
        
        public string AddProduct(TYPPrototype.ProductService.Product product) {
            return base.Channel.AddProduct(product);
        }
        
        public System.Threading.Tasks.Task<string> AddProductAsync(TYPPrototype.ProductService.Product product) {
            return base.Channel.AddProductAsync(product);
        }
        
        public string UpdateProduct(TYPPrototype.ProductService.Product product) {
            return base.Channel.UpdateProduct(product);
        }
        
        public System.Threading.Tasks.Task<string> UpdateProductAsync(TYPPrototype.ProductService.Product product) {
            return base.Channel.UpdateProductAsync(product);
        }
    }
}
