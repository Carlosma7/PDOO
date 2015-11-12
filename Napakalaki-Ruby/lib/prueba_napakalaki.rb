# # Clase para hacer las pruebas del juego
# Autores: Javier Aranda Izquierdo
#          Carlos 

require_relative "bad_consequence"
require_relative "prize"
require_relative "monster"
require_relative "treasure_kind"

handTreasures = Array.new  #Array para los terosoros de las manos de Bicefalo
handTreasures << [TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND]


# CONSULTAS
# Monstruos cuyo nivel de combate supera a 10
puts "Monstruos cuyo nivel de combate supera a 10"
puts  #Salto de línea

for m in monsters
  if m.LevelExceeding10
    puts m.to_s
  end
end

puts  #Salto de línea

# Monstruos cuyo mal rollo solo implica perdida de niveles
puts "Monstruos cuyo mal rollo solo implica perdida de niveles"
puts  #Salto de línea

for m in monsters
  if m.OnlyLevelsBadConsequence
    puts m.to_s
  end
end

puts #Salto de línea

# Monstruos que tengan un buen rollo que indique una ganancia de niveles superior a 1.
puts "Monstruos que tengan un buen rollo que indique una ganancia de niveles superior a 1"
puts  #Salto de línea

for m in monsters
  if m.PrizeLevelsExceeding1
    puts m.to_s
  end
end

# Monstruos que tengan un mal rollo que suponga la perdida de un 
# determinado tipo de tesoros ya sea visibles y/o ocultos.
puts "Monstruos que tengan un mal rollo que suponga la perdida de un
determinado tipo de tesoros ya sea visibles y/o ocultos."
puts  #Salto de línea

for m in monsters
  if m.LoseSpecificTreasures
    puts m.to_s
    puts m.price.to_s
    puts m.badConsequence.to_s
    puts #Salto de línea
  end
end


