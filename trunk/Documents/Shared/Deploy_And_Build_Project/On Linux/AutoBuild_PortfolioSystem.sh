#!/bin/bash
PROJECT_PATH="/home/emerald/workspace/shop-management-system/Portfolio_System"
PROJECT_NAME="PortfolioSystem"
JBOSS_PATH="/home/emerald/Documents/devtools/jboss-as-7.1.1.Final"

cd $PROJECT_PATH
mvn clean
mvn package

sudo rm -rf $JBOSS_PATH/standalone/deployments/$PROJECT_NAME.war
sudo rm -rf $JBOSS_PATH/standalone/deployments/$PROJECT_NAME.war*

sudo cp $PROJECT_PATH/target/$PROJECT_NAME.war $JBOSS_PATH/standalone/deployments/$PROJECT_NAME.war

