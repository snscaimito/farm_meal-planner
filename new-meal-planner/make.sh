#!/bin/bash
gradle clean generateSite
bundle update
cucumber
