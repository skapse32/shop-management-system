set jboss_folder=C:\jboss-as-7.1.1.Final
set Portfolio_System_folder=G:\Java\CongDongJava\shop-management-system\Portfolio_System
title Delete old file at [jboss]\standalone\deployments
del %jboss_folder%\standalone\deployments\PortfolioSystem.war
del %jboss_folder%\standalone\deployments\PortfolioSystem.war.deployed
title Copying new file to [jboss]\standalone\deployments
copy %Portfolio_System_folder%\target\PortfolioSystem.war %jboss_folder%\standalone\deployments
title Deploy done!!!
