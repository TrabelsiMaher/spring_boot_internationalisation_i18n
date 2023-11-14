# spring_boot_internationalisation_i18n

*creation du RestController avec le mapping "/api"
*crétion de la classe ConfigurationLocal dans un package config avec annotation @Configuration
*dans le dossier resources, crétion un new folder i18n_message
dans ce dernier oin créera trois fichiers : 
messages.properties 
messages_fr.properties 
et messages_en.properties

=> dans la classe dde configuration, on créera un Bean de type LocalResolver
*ajouter dans le fichier application.properties l'entrées suivantes : 
spring.messages.basename=i18n_message/messages
spring.messages.encoding=UTF-8

* Dans le controlleur : 
	1- ajout un attribut de type MessageSource
	2- créer un constructor avec fields
	3- créer une fonction getMessage avec le path "/standard"
* Dans les fichiers du dossier i18n_message
 common.hi=
et dans chaque fichier metter tous ce que vous voules comme valeurs ;)
la fonction dans le controlleur on mettra comme code :
////
return messageSource.getMessage("common.hi", null,LocaleContextHolder.getLocale());
////
tester avec postman et consulter l'url :
 http://localhost:8080/api/standard
==> vous aurez donc le message suivant le ficheir de configuration du locale qui vous convient

 Dans le controlleur : 
	1- créer une fonction getMessage avec le path "/header_attachement"
Cette fonction va accepter de Header "Accept-language"
@RequestHeader(name="Accept-Language",required = false) Locale local
et aura comme code comme la précédente

////
ont test avec potman l'url : 
http://localhost:8080/api/header_attachement
==> on mettra le heasder : Accept-Language : fr ou en

le résultat  reste le mm dans les deux cas par ce que le programme 
tien en compte seulement de la confioguratio qui utilise le resolver suivant le local de la machine qui tourne l'app

on modif la conf comme suit : 
@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver  sessionLocaleResolver=new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.FRENCH);
		return sessionLocaleResolver;
	}
=====>>>> Maintenant il marche comme prévut :) :) :)
