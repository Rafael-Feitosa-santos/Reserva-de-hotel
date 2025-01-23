@echo off
cls
echo ####################################
echo ### Compilando discovery-reserva ###
echo ####################################
cd discovery-reserva
rmdir /s /q target
call mvn clean install -U
pause
cls
echo #############################
echo ### Gerando imagem Docker ###
echo ###   discovery-reserva   ###
echo #############################
call docker image build -t discovery-reserva .
pause
echo ###################################
echo ### Fim Compilacao discovery-reserva ###
cd ..

cls
echo ###############################
echo ### Compilando gateway ###
echo ###############################
cd gateway
rmdir /s /q target
call mvn clean install -U
pause
cls
echo #############################
echo ### Gerando imagem Docker ###
echo ###      gateway     ########
echo #############################
call docker image build -t gateway .
pause
echo ###################################
echo ### Fim Compilacao gateway ###
cd ..

cls
echo ##################################
echo ### Compilando cadastro_hotel ###
echo ##################################
cd cadastro_hotel
rmdir /s /q target
call mvn clean install -U
pause
cls
echo ##################################
echo ### Gerando imagem Docker #######
echo ###       cadastro-hotel      ###
echo #################################
call docker image build -t cadastro-hotel .
pause
echo ### Fim Compilacao cadastro-hotel ###
cd ..

cls
echo #############################
echo ### Compilando reserva ######
echo #############################
cd reserva
rmdir /s /q target
call mvn clean install -U
pause
cls
echo #############################
echo ### Gerando imagem Docker ###
echo ###       reserva      ######
echo #############################
call docker image build -t reserva .
pause
echo ### Fim Compilacao reserva ###
cd ..