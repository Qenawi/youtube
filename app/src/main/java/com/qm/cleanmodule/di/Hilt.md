#@AndroidEntryPoint <Scoped injection>
Once you have enabled members injection in your Application, you can start enabling members injection in your other Android 
classes using the @AndroidEntryPoint annotation. You can use @AndroidEntryPoint on the following types:
- applicable for <activity , fragment , view , service , broadCastReceiver> 
#@InstallIn(X::class)
annotation followed by module or submodules 
- adding that module/submodules to X class as sub-module/modules
- by default Hilt has preGenerated component  
#@HiltViewModel
 -act as same as @AndroidEntryPoint but for view model 
#@ViewModelScoped 
All Hilt View Models are provided by the 
ViewModelComponent which follows the same lifecycle as a ViewModel, i.e. it survives configuration changes. To scope a dependency
to a ViewModel use the @ViewModelScoped annotation,
A @ViewModelScoped type will make it so that a single instance 
of the scoped type is provided across all dependencies injected into the Hilt View Model. Other instances of a ViewModel that requests the scoped instance will receive a different instance. Scoping to the ViewModelComponent 
allows for flexible and granular scope since View Models 