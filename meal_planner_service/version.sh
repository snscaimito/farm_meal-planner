#!/bin/bash

version=`mvn org.apache.maven.plugins:maven-help-plugin:2.2:evaluate -Dexpression=project.version | grep "^[0-9].[0-9].[0-9]"`

echo $version
